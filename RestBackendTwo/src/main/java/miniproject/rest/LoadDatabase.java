package miniproject.rest;

import miniproject.rest.model.employee.Employee;
import miniproject.rest.model.order.Order;
import miniproject.rest.model.order.Status;
import miniproject.rest.repository.EmployeeRepository;
import miniproject.rest.repository.OrderRepository;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository empRepo, OrderRepository orderRepo) {

        return args -> {

            //Add Employees to the database
            empRepo.save(new Employee("Thomas", "Ebsen", "te@mail.com", "CEO"));
            empRepo.save(new Employee("Jonas", "Hein", "jh@mail.com", "CFO"));
            empRepo.save(new Employee("Andreas", "Jørgensen", "jj@mail.com", "CGO"));
            empRepo.save(new Employee("Jonatan", "Bakke", "jb@mail.com", "CAO"));
            empRepo.findAll().forEach(employee -> log.info("[PRELOADED] " + employee));

            //Add Orders to the database
            orderRepo.save(new Order("DELL XPS15", Status.COMPLETED));
            orderRepo.save(new Order("Programming for dummies VOL1", Status.IN_PROGRESS));
            orderRepo.save(new Order("ORDER ERROR", Status.CANCELLED));
            orderRepo.findAll().forEach(order -> log.info("[PRELOADED] " + order));
        };
    }
}
