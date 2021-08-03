package me.loda.spring.configurationpropertiesanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@EnableConfigurationProperties
public class App implements CommandLineRunner {
    @Autowired
    LodaAppProperties lodaAppProperties;
    public static void main (String[] args) {
//        ApplicationContext context = SpringApplication.run(App.class, args);
//        LodaAppProperties lodaAppProperties = context.getBean(LodaAppProperties.class);
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global variable:");
        System.out.println("\t Email: " + lodaAppProperties.getEmail());
        System.out.println("\t GA ID: " + lodaAppProperties.getGoogleAnalyticsId());
        System.out.println("\t Authors: " + lodaAppProperties.getAuthors());
        System.out.println("\t Example Map: " + lodaAppProperties.getExampleMap());
    }
}
