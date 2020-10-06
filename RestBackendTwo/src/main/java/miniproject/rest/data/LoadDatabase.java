package miniproject.rest.data;

import miniproject.rest.model.Cart;
import miniproject.rest.model.Item;
import miniproject.rest.model.Status;
import miniproject.rest.repository.CartRepository;
import miniproject.rest.repository.ItemRepository;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CartRepository cartRepo, ItemRepository itemRepo) {

        return args -> {
            List<Cart> cartList = new ArrayList<Cart>();
            cartList.add(new Cart("ORDER ERROR", Status.CANCELLED));
            cartList.add(new Cart("DELL XPS15", Status.COMPLETED));
            cartList.add(new Cart("Programming for dummies VOL1", Status.IN_PROGRESS));
            for (Cart c: cartList) {cartRepo.save(c);} //Save all orders
            cartRepo.findAll().forEach(cart -> log.info("[PRELOADED] " + cart));


            //Add Orders to the database
            List<Item> itemList = new ArrayList<Item>();
            itemList.add(new Item("DELL XPS15", "The newest dell pc", cartList.get(1)));
            itemList.add(new Item("Macbook Pro", "The newest macbook", cartList.get(1)));
            for (Item i : itemList) {itemRepo.save(i);}
            itemRepo.findAll().forEach(item -> log.info("[PRELOADED] " + item));
        };
    }
}
