package miniproject.rest.repository;

import miniproject.rest.model.Cart;
import miniproject.rest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCart(Cart cart);
}
