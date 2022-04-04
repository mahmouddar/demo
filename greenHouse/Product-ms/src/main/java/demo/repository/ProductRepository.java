package demo.repository;

import demo.entity.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    @Query(value = "SELECT * FROM products p WHERE p.ID IN :ids", nativeQuery = true)
    List <Product> findProductByIds(@Param("ids") List<Long> ids);

    List<Product> findByName(String lastName);

    Product findById(long id);

    List<Product> findAll();


}
