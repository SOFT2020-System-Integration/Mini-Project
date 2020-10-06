package miniproject.rest.repository;

import miniproject.rest.model.Cart;
import miniproject.rest.model.Item;

import java.io.Serializable;
import java.util.List;

public class embedded implements Serializable {

    private List<Cart> carts;

    private List<Item> items;

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
