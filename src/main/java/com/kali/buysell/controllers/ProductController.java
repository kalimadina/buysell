package com.kali.buysell.controllers;


import com.kali.buysell.models.Product;
import com.kali.buysell.services.ProductServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductServise productServise;
    @GetMapping("/")
    public String products(Model model){
        model.addAttribute("products", productServise.listProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productServise.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productServise.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServise.deleteProduct(id);
        return "redirect:/";
    }
}
