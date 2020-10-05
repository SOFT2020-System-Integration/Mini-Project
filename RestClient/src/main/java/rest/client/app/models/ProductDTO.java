package rest.client.app.models;

import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private boolean inStock;
    private List<CategoryDTO> categories;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, Long quantity, boolean inStock, List<CategoryDTO> categories) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.inStock = inStock;
        this.categories = categories;
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", inStock=" + inStock +
                ", categories=" + categories +
                '}';
    }
}
