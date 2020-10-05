package miniproject.rest.exceptions.cart;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(Long id) {
        super("Could not find cart with id: " + id);
    }
}
