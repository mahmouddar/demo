package demo.entity;

import javax.persistence.*;


@Table(name = "ORDERS")
@Entity
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "CUSTOMER_ID")
    private
    Long customerId;

    @Column(name = "PRODUCT_ID")
    private
    Long productId;


    public Order() {}

    public Order(Long customerId, Long productId) {
        this.customerId = customerId;
        this.productId = productId;
    }


    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, customerId=%d, productId=%d]",
                orderId, customerId, productId);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


}
