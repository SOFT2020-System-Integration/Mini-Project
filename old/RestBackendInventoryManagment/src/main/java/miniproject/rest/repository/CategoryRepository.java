package miniproject.rest.repository;

import miniproject.rest.model.Category;
import miniproject.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(@Param("name") String name); //Custom search parameter that allow us to find a category by its name instead of e.g. it's id
}
