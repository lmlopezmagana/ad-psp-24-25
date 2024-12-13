package com.example.demo.service;

import com.example.demo.error.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> result = productRepository.getAll();
        if (result.isEmpty())
            throw new ProductNotFoundException();
        return result;
    }

    public List<Product> query(double maxPrice, String sortDirection) {
        List<Product> result = productRepository.query(maxPrice, sortDirection);
        if (result.isEmpty())
            throw new ProductNotFoundException();
        return result;
    }

    public Product get(Long id) {
        return productRepository.get(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product add(Product product) {
        return productRepository.add(product);
    }

    public Product edit(Long id, Product newValue) {
        return productRepository.edit(id, newValue)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}

