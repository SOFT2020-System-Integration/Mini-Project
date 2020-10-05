package miniproject.rest.exceptions.cart;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super("Could not find item with id: " + id);
    }
}
