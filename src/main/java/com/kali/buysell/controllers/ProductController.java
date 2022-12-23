package com.kali.buysell.controllers;


import com.kali.buysell.models.Image;
import com.kali.buysell.models.Product;
import com.kali.buysell.services.ProductServise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public String createProduct(@PathVariable("file1") MultipartFile file1,
                                @PathVariable("file2") MultipartFile file2,
                                @PathVariable("file3") MultipartFile file3,
                                Product product) throws IOException {
        productServise.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productServise.deleteProduct(id);
        return "redirect:/";
    }
}
