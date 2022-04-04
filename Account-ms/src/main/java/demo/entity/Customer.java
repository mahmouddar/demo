package demo.entity;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@Table(name = "CUSTOMERS")
@Entity
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "FIRST_NAME")
    private
    String firstName;

    @Column(name = "LAST_NAME")
    private
    String lastName;

    @Column(name = "ACTIVE")
    private
    Boolean active;

    @Transient
    private List<Product> product;


    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Customer() {}

    public Customer(String firstName, String lastName, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public Customer(Long id, String lastName) {
        this.customerId = id;
        this.lastName = lastName;
        this.active = Boolean.FALSE;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                customerId, firstName, lastName);
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getContactId() {
        return customerId;
    }

    public void setContactId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
