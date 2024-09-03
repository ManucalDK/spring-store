package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService _productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return _productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@RequestParam String id) {
        return _productService.getProductById(id);
    }
    
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return _productService.addProduct(product);
    }
    
}
