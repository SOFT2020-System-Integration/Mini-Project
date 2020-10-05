package miniproject.rest.repository;

import miniproject.rest.model.order.Cart;
import miniproject.rest.model.order.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCart(Cart cart);
}
