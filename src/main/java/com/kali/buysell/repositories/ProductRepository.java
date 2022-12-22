package com.kali.buysell.repositories;

import com.kali.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {
}
