package miniproject.rest.service;

import miniproject.rest.model.Category;
import miniproject.rest.model.Product;

import java.util.Collection;


//A custom serice that provide CRUD operations for the Categories
public interface CategoryService {

    //Find all categories as a collection
    public Collection<Category> findAll();

    //Find category by it's id
    public Category findById(Long id);

    //Find category by its name
    public Category findByName(String name);

    //Create a new category
    public Category create(Category category);

    //Update existing category
    public Category update(Category category);

    //Add a product do a category
    public Collection<Product> addProduct(Long categoryId, Long productId);

    //Delete category by it's id
    public void delete(Long id);

}
