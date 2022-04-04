package demo.conroller;

import demo.entity.Product;
import demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ranges.Range;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {


    @Autowired
    private
    ProductRepository productRepository;


    @GetMapping("/products")
    public List<Product> productAll(@RequestParam(value = "name", defaultValue = "GreenHouse") String name) {
        return productRepository.findAll();
    }


    @GetMapping("products/{productId}")
    public Product productById(@PathVariable Long productId){
        Optional<Product> product =  productRepository.findById(productId);
        return product.orElse(null);
    }

    @GetMapping("productsbatch/{productIds}")
    public List<Product> productByIds(@PathVariable List<Long> productIds){
        List<Product> products = productRepository.findProductByIds(productIds);
        return products;
    }



}
