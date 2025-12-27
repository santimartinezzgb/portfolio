package com.myspring.demospringboot.triggers;

import com.myspring.demospringboot.repository.ProductRepository;
import com.myspring.demospringboot.repository.RepoTarjeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataBulkInsertApplication implements CommandLineRunner {

    @Value("${documentCount}")
    private int count;
    private static final Logger LOG = LoggerFactory
            .getLogger(SpringDataBulkInsertApplication.class);

    @Autowired
    private RepoTarjeta repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataBulkInsertApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Este sirve para ejecutar código después de iniciar la aplicación
        repository.bulkInsertTarjetas(count);
        LOG.info("End run");
        //System.exit(0);
    }
}