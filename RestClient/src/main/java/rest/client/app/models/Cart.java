package rest.client.app.models;

import java.util.Set;

public class Cart {
    private Long id;
    private String description;
    private Status status;
    private Set<Item> items;

    public Cart() {
    }

    public Cart(String description, Status status, Set<Item> items) {
        this.description = description;
        this.status = status;
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", items=" + items +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
