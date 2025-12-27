package com.myspring.demospringboot.repository;

import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.result.UpdateResult;
import com.myspring.demospringboot.model.Product;
import com.myspring.demospringboot.model.Tarjeta;
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
public class RepoTarjeta {
    private static final Logger LOG = LoggerFactory
            .getLogger(RepoTarjeta.class);

    private final MongoTemplate mongoTemplate;

    // Inyección de dependencia del MongoTemplate
    @Autowired
    public RepoTarjeta(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }


    // Inserta en bloque una cantidad especificada de productos aleatorios
    public void bulkInsertTarjetas(int count) {

        LOG.info("Dropping collection...");
        mongoTemplate.dropCollection(Tarjeta.class);
        LOG.info("Dropped!");

        Instant start = Instant.now();
        mongoTemplate.setWriteConcern(WriteConcern.W1.withJournal(true));

        List<Tarjeta> lista_tarjetas = Tarjeta.proyectos();
        BulkOperations bulkInsertion = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, Tarjeta.class);

        bulkInsertion.insert(lista_tarjetas);

        BulkWriteResult bulkWriteResult = bulkInsertion.execute();

        LOG.info("Bulk insert of " + bulkWriteResult.getInsertedCount() + " documents completed in " + Duration.between(start, Instant.now()).toMillis() + " milliseconds");
        bulkWriteResult.getInsertedCount();
    }
}