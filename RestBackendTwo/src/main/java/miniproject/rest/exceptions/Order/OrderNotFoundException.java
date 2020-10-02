package miniproject.rest.exceptions.Order;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find order with id: " + id);
    }
}
