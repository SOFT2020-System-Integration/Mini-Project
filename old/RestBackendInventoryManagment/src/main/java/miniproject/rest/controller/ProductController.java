package miniproject.rest.controller;

import miniproject.rest.exceptions.ProductNotFoundException;
import miniproject.rest.model.Category;
import miniproject.rest.model.Product;
import miniproject.rest.repository.ProductRepository;
import miniproject.rest.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductService service;

   @GetMapping("")
    public ResponseEntity<Collection<Product>> getAllProducts() {
       Collection<Product> products = service.findAll();
       return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
      Product product = service.findById(id);
      if(product == null) {
         return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<Product>(product, HttpStatus.OK);
   }

   @PostMapping("")
   public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
      product = service.create(product);
      if(product == null) {
         return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
      return new ResponseEntity<>(product, HttpStatus.CREATED);
   }

   @PutMapping("")
   public ResponseEntity<Product> updateExistingProduct(@RequestBody Product product) {
      product = service.update(product);
      if(product == null) {
         return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
      return new ResponseEntity<>(product, HttpStatus.OK);
   }

   @DeleteMapping("")
   public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id) {
      service.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }



}
