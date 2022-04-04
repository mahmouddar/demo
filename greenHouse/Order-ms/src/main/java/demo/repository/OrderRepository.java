package demo.repository;

import demo.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    List<Order> findByCustomerId(Long id);

    Order findById(long id);

    List<Order> findAll();

}
