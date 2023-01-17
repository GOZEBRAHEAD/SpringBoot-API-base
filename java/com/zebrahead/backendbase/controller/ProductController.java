package com.zebrahead.backendbase.controller;

import com.zebrahead.backendbase.exception.ProductNotFoundException;
import com.zebrahead.backendbase.model.Product;
import com.zebrahead.backendbase.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/get/all") // Getting all the products
    List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/get/{id}") // Getting a product by ID
    Product getProductByID(@PathVariable Long id) {
        return productRepository.findById(id)
                                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/products/new") // Adding a specific product
    Product createProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @PutMapping("/products/edit/{id}") // Edit a product
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productRepository.findById(id)
                                .map(actualProduct -> {
                                    actualProduct.setName(newProduct.getName());
                                    actualProduct.setPrice(newProduct.getPrice());
                                    return productRepository.save(actualProduct);
                                }).
                                orElseThrow(() -> new ProductNotFoundException(id));
    }

    @DeleteMapping("/products/delete/{id}") // Delete a product
    String deleteProduct(@PathVariable Long id) {

        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        productRepository.deleteById(id);

        return "Product with id " + id + " has been deleted successfully.";
    }
}
