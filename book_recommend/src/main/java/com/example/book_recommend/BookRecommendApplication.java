package com.example.book_recommend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@MapperScan("com.example.book_recommend.dao")
@SpringBootApplication()
//@ComponentScan(basePackages = {"com.example.book_recommend.dao"})
public class BookRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookRecommendApplication.class, args);
    }

}
