package com.kali.buysell.services;

import com.kali.buysell.models.Product;
import com.kali.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServise {
    private final ProductRepository productRepository;
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
