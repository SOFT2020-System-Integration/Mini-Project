package miniproject.rest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private boolean inStock;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private List<Category> categories;

    public Product() {
    }

    public Product(Long id, String name, String description, Long quantity, boolean inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public Product(String name, String description, Long quantity, boolean inStock) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
