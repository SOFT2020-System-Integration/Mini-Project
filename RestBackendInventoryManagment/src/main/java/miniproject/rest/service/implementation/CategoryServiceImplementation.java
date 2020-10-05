package miniproject.rest.service.implementation;

import miniproject.rest.exceptions.CategoryNotFoundException;
import miniproject.rest.model.Category;
import miniproject.rest.model.Product;
import miniproject.rest.repository.CategoryRepository;
import miniproject.rest.repository.ProductRepository;
import miniproject.rest.service.CategoryService;
import miniproject.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private ProductService prodService;

    @Override
    public Collection<Category> findAll() {
        Collection<Category> categories = catRepo.findAll();
        return categories;
    }

    @Override
    public Category findById(Long id) {
        Category category = catRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        return category;
    }

    @Override
    public Category findByName(String name) {
        Category category = catRepo.findByName(name);
        if(category == null) {
            throw new RuntimeException("Category with name: " + name + " not found...");
        }
        return category;
    }

    @Override
    public Category create(Category category) {
        catRepo.save(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        catRepo.save(category);
        return category;
    }

    @Override
    public Collection<Product> addProduct(Long categoryId, Long productId) {

        Category category = findById(categoryId);
        Product product = prodService.findById(productId);
        if (category == null || product == null ) {
            return null;
        }

        List<Product> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        catRepo.save(category);
        return category.getProducts();
    }

    @Override
    public void delete(Long id) {
        Category category = findById(id);
        if(category == null) {
            return;
        }
        catRepo.deleteById(id);
    }
}
