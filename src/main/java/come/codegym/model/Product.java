package come.codegym.model;

public class Product {

    private Long id;
    private String productName;
    private Long categoryId;
    private Long price;
    private Long quantity;
    private String color;

    public Product() {

    }

    public Product(Long id, String productName, Long categoryId, Long price, Long quantity, String color) {
        this.id = id;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Product(String productName, Long categoryId, Long price, Long quantity, String color) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
