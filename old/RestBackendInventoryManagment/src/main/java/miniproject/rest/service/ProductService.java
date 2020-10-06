package miniproject.rest.service;

import miniproject.rest.model.Product;

import java.util.Collection;

//Service that provides CRUD opertaions to our Product
public interface ProductService {

    //Find a collection of all Products
    public Collection<Product> findAll();

    //Find a Product by it's id
    public Product findById(Long id);

    //Find a Product by it's name
    public Product findByName(String name);

    //Create a new product
    public Product create(Product product);

    //Update an existing product
    public Product update(Product product);

    //Delete a product by it's id
    public void delete(Long id);
}
