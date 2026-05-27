package com.nt.Conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.Model.Product;
import com.nt.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // ADD PRODUCT
    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) {

        return service.addProduct(product);
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {

        return service.getAllProducts();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {

        return service.getProductById(id);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,
                                 @Valid @RequestBody Product product) {

        return service.updateProduct(id, product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {

        return service.deleteProduct(id);
    }
}