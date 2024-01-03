package com.shubhada.springrediscachedbdemo.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shubhada.springrediscachedbdemo.models.Product;
import com.shubhada.springrediscachedbdemo.repositories.ProductRepository;
import com.shubhada.springrediscachedbdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);

    }

    @GetMapping
    @JsonProperty("collection")
    public List<Product> getAllProducts(){

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable Long id){

        return productService.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id){
        return productService.deleteProduct(id);

    }
}
