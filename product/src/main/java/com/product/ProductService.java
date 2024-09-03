package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;

    public List<Product> getAllProducts(){
        return _productRepository.findAll();
    }

    public Product getProductById(String id){
        return _productRepository.findById(id)
            .orElse(null);
    }

    public Product addProduct(Product product){
        return _productRepository.save(product);
    }
}
