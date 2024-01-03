package com.shubhada.springrediscachedbdemo.services;

import com.shubhada.springrediscachedbdemo.models.Product;
import com.shubhada.springrediscachedbdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {
       @Autowired
       private ProductRepository repository;



    public Product save(Product product) {
        return repository.save(product);
    }


    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findProductById(Long id) {

        return repository.findProductById(id);
    }

    public String deleteProduct(Long id) {
        return repository.deleteProduct(id);
    }
}
