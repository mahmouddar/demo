package demo;

import demo.entity.Product;
import demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("demo/repository")
@EntityScan("demo/entity")
public class AccessingDataJpaApplication{


    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(AccessingDataJpaApplication .class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Product("iphone", 5449.99,Boolean.TRUE));
            repository.save(new Product("galaxy", 3199.99,Boolean.TRUE));
            repository.save(new Product("lenovo", 1999.99,Boolean.TRUE));
            repository.save(new Product("huawei", 2999.99,Boolean.TRUE));
            repository.save(new Product("xiaomi", 1499.99,Boolean.FALSE));

            // fetch all customers
            log.info("Products found with findAll():");
            log.info("-------------------------------");
            for (Product product : repository.findAll()) {
                log.info(product.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Product product = repository.findById(1L);
            log.info("Product found with findById(1L):");
            log.info("--------------------------------");
            log.info(product.toString());
            log.info("");

            // fetch products by  name
            log.info("Products found with findByName('iphone'):");
            log.info("--------------------------------------------");
            repository.findByName("iphone").forEach(ln -> {
                log.info(ln.toString());
            });

            log.info("");
        };
    }



}
