package org.example;
// Make sure this is the correct package for your project

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  // Marks this class as the main Spring Boot application
public class Main {

    public static void main(String[] args) {
        // Run the Spring Boot application
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Registered beans:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
