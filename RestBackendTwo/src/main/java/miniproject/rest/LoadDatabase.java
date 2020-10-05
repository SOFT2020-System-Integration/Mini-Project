package miniproject.rest;

import miniproject.rest.model.employee.Employee;
import miniproject.rest.model.order.Cart;
import miniproject.rest.model.order.Item;
import miniproject.rest.model.order.Status;
import miniproject.rest.repository.EmployeeRepository;
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
    CommandLineRunner initDatabase(EmployeeRepository empRepo, CartRepository cartRepo, ItemRepository itemRepo) {

        return args -> {

            //Add Employees to the database


            empRepo.save(new Employee("Thomas", "Ebsen", "te@mail.com", "CEO"));
            empRepo.save(new Employee("Jonas", "Hein", "jh@mail.com", "CFO"));
            empRepo.save(new Employee("Andreas", "Jørgensen", "jj@mail.com", "CGO"));
            empRepo.save(new Employee("Jonatan", "Bakke", "jb@mail.com", "CAO"));
            empRepo.findAll().forEach(employee -> log.info("[PRELOADED] " + employee));

            List<Cart> cartList = new ArrayList<Cart>();
            cartList.add(new Cart("ORDER ERROR", Status.CANCELLED));
            cartList.add(new Cart("DELL XPS15", Status.COMPLETED));
            cartList.add(new Cart("Programming for dummies VOL1", Status.IN_PROGRESS));
            for (Cart c: cartList) {cartRepo.save(c);} //Save all orders
            cartRepo.findAll().forEach(order -> log.info("[PRELOADED] " + order));


            //Add Orders to the database
            List<Item> itemList = new ArrayList<Item>();
            itemList.add(new Item("DELL XPS15", "The newest dell pc", cartList.get(1)));
            itemRepo.save(itemList.get(0));
        };
    }
}
