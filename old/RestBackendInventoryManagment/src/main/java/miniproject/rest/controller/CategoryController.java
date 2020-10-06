package miniproject.rest.controller;

import miniproject.rest.exceptions.CategoryNotFoundException;
import miniproject.rest.exceptions.ProductNotFoundException;
import miniproject.rest.model.Category;
import miniproject.rest.model.Product;
import miniproject.rest.repository.CategoryRepository;
import miniproject.rest.repository.ProductRepository;
import miniproject.rest.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;


    @GetMapping("")
    public ResponseEntity<Collection<Category>> getAllProducts() {
        Collection<Category> categories = new ArrayList<Category>();
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Category cat = service.findById(id);
        if(cat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cat, HttpStatus.OK);
    }

    @GetMapping("/{catId}/products/{prodId}")
    public ResponseEntity<Collection<Product>> getAProductFromACategory(@PathVariable("catId") Long catId, @PathVariable("prodId") Long prodId) {
        Category category = service.findById(catId);
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getProducts(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> createNewCategory(@RequestBody Category category) {
        category = service.create(category);
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateExistingCategoryByCategoryId(@RequestBody Category category) {
        category = service.update(category);
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @RequestMapping(value="/{categoryId}/products/{productId}",
            method=RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Product>> addProductToCategory(@PathVariable("categoryId") Long categoryId, @PathVariable("productId") Long productId){

        Collection<Product> products = service.addProduct(categoryId, productId);
        if (products == null) {
            return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);

    }
}
