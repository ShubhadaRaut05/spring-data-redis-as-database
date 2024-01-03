package com.shubhada.springrediscachedbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {RedisRepositoriesAutoConfiguration.class})
public class SpringRedisCachedbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCachedbDemoApplication.class, args);
    }

}
