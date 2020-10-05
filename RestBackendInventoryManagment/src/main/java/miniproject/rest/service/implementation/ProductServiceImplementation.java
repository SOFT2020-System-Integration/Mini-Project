package miniproject.rest.service.implementation;

import miniproject.rest.exceptions.ProductNotFoundException;
import miniproject.rest.model.Product;
import miniproject.rest.repository.ProductRepository;
import miniproject.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public Collection<Product> findAll() {
        Collection<Product> products = prodRepo.findAll();
        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = prodRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return product;
    }

    @Override
    public Product findByName(String name) {
        Product product = prodRepo.findByName(name);
        if(product == null) {
            throw new RuntimeException("Product with name: " + name + " not found...");
        }
        return product;
    }

    @Override
    public Product create(Product product) {
        if(product == null) {
            return null;
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = findById(product.getId());
        if(productToUpdate == null) {
            return null;
        }
        prodRepo.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        if(product == null)
            return;
        prodRepo.deleteById(id);
    }
}
