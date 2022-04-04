package demo.repository;

import demo.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findAll();

    Customer findById(long id);

    @Query(value = "SELECT * FROM customers c", nativeQuery = true)
    List<Customer> findAllActiveCustomers();
}
