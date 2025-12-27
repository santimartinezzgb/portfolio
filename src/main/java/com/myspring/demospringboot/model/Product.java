package com.myspring.demospringboot.model;

import com.mongodb.internal.diagnostics.logging.Logger;
import net.datafaker.Faker;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Document("products")
public class Product {

    @Id
    private String id;
    private String name;
    private int qty;
    private double price;
    private Date available;
    private Date  unavailable;
    private String skuId;

    public Product(String name, int qty, double price, Date available, Date unavailable, String skuId) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.available = available;
        this.unavailable = unavailable;
        this.skuId = skuId;
    }

    public static List<Product> randomProducts(int  count) {
        Faker faker = new Faker();
        Random rand = new Random();
        List<Product> retProds = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
            Product product = new Product(faker.animal().name(),
                    1 + rand.nextInt(998),
                    10.0 + rand.nextInt(9999),
                    new Date(), new Date(),
                    faker.idNumber().valid());
            retProds.add(product);
        }
        return retProds;
    }

    // Getters and setters
}