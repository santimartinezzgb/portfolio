package com.myspring.demospringboot.repository;

import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;
import com.myspring.demospringboot.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

// Este repositorio maneja operaciones de productos en MongoDB
@Repository
public class ProductRepository {
    private static final Logger LOG = LoggerFactory
            .getLogger(ProductRepository.class);

    private final MongoTemplate mongoTemplate;

    // Inyección de dependencia del MongoTemplate
    @Autowired
    public ProductRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    // Actualiza la cantidad de un producto dado su nombre
    public void updateProductQuantity(String name, int newQuantity) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update();
        update.set("quantity", newQuantity);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Product.class);

        if (result == null)
            LOG.error("No documents updated");
        else
            LOG.info(result.getModifiedCount() + " document(s) updated..");
    }

    // Inserta en bloque una cantidad especificada de productos aleatorios
    public void bulkInsertProducts(int count) {

        LOG.info("Dropping collection...");
        mongoTemplate.dropCollection(Product.class);
        LOG.info("Dropped!");

        Instant start = Instant.now();
        mongoTemplate.setWriteConcern(WriteConcern.W1.withJournal(true));

        List<Product> productList = Product.randomProducts(count);
        BulkOperations bulkInsertion = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Product.class);

        bulkInsertion.insert(productList);

        BulkWriteResult bulkWriteResult = bulkInsertion.execute();

        LOG.info("Bulk insert of " + bulkWriteResult.getInsertedCount() + " documents completed in " + Duration.between(start, Instant.now()).toMillis() + " milliseconds");
        bulkWriteResult.getInsertedCount();
    }
}