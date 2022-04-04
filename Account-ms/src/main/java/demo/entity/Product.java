package demo.entity;


public class Product {


    private Long productId;


    private
    String name;


    private
    Double price;


    private
    Boolean active;

    public Product() {}

    public Product(String name, Double price, Boolean active) {
        this.name = name;
        this.price = price;
        this.active = active;
    }

    public Product(Long id, String name) {
        this.productId = id;
        this.name = name;
        this.active = Boolean.FALSE;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%d, name='%s', price='%f']",
                productId, name, price);
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
