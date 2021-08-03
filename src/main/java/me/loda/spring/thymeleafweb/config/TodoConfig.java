package me.loda.spring.thymeleafweb.config;

import me.loda.spring.thymeleafweb.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    @Bean
    public TodoValidator validator(){
        return new TodoValidator();
    }
}
