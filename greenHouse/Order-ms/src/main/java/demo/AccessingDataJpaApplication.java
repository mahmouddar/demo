package demo;

import demo.entity.Order;
import demo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("demo/repository")
@EntityScan("demo/entity")
public class AccessingDataJpaApplication{


    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {


        SpringApplication.run(AccessingDataJpaApplication .class, args);
    }



    @Bean
    public CommandLineRunner demo(OrderRepository repository) {
        return (args) -> {
            // save a few orders
            repository.save(new Order(1L, 1L));
            repository.save(new Order(2L, 3L));
            repository.save(new Order(1L, 3L));
            repository.save(new Order(3L, 5L));
            repository.save(new Order(4L, 1L));

            // fetch all customers
            log.info("Orders found with findAll():");
            log.info("-------------------------------");
            for (Order order : repository.findAll()) {
                log.info(order.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Order order = repository.findById(1L);
            log.info("Order found with findById(1L):");
            log.info("--------------------------------");
            log.info(order.toString());
            log.info("");

            // fetch products by  name
            log.info("Products found with findByName('iphone'):");
            log.info("--------------------------------------------");
            repository.findByCustomerId(1L).forEach(ln -> {
                log.info(ln.toString());
            });

            log.info("");
        };
    }



}
