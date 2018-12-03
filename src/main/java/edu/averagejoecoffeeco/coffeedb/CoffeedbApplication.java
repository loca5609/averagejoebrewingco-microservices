package edu.averagejoecoffeeco.coffeedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CoffeedbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeedbApplication.class, args);

    }
}