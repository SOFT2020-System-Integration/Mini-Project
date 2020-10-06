package miniproject.rest.repository;

import miniproject.rest.exceptions.CategoryNotFoundException;
import miniproject.rest.exceptions.ProductNotFoundException;
import miniproject.rest.model.Category;
import miniproject.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(@Param("name") String name); //Custom search parameter that allow us to find for a product by its name
}
