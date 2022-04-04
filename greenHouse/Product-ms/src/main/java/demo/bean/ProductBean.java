package demo.bean;

import demo.conroller.ProductController;
import demo.entity.Product;
import demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

public class ProductBean {

    @Autowired
    private
    ProductRepository productRepository;


}
