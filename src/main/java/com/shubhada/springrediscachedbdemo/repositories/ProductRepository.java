package com.shubhada.springrediscachedbdemo.repositories;

import com.shubhada.springrediscachedbdemo.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class ProductRepository {
    private static final String HASH_KEY ="Product" ;
    @Autowired
    private RedisTemplate template;

    //write method to save product
/*public ProductRepository(RedisTemplate template){
    this.template=template;
}*/
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;//return product that persist
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }
    public Product findProductById(Long id){

        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(Long id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
