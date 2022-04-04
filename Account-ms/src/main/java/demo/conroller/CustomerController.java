package demo.conroller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.entity.Product;
import demo.repository.CustomerRepository;
import demo.entity.Customer;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;


@RestController
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> customerAll(@RequestParam(value = "name", defaultValue = "GreenHouse") String name) {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer customerFindById(@PathVariable Long customerId,@RequestParam(required = false)String include) throws JSONException, JsonProcessingException {

        Optional<Customer> customer = customerRepository.findById(customerId);
        //retrieve from orders ms all orders belongs to customerId
        //for each order retrieve product details from product ms
        if(include != null && include.contains("products")) {
            String response = new RestTemplate().getForObject("http://localhost:8081/ordersbycustomer/" + customerId, String.class, customerId);
            JSONArray jsonArray = new JSONArray(response);
            StringBuilder url = new StringBuilder("http://localhost:8082/productsbatch/");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject order = jsonArray.getJSONObject(i);
                if (order.has("productId")) {
                    url.append(order.get("productId"));
                    url.append(",");
                }
            }
            url.setLength(url.length() - 1);
            String prodResponse = new RestTemplate().getForObject(url.toString(), String.class, 1);
            ObjectMapper mapper = new ObjectMapper();
            if (prodResponse != null && customer.isPresent()) {
                customer.get().setProduct(mapper.readValue(prodResponse, new TypeReference<List<Product>>() {
                }));
            }
        }

        return customer.orElse(null);

    }







}
