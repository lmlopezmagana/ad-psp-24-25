package com.salesianostriana.dam.test;

import lombok.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"test"})
@Testcontainers
@Sql(value = "classpath:insert-product.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:delete-product.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ProductoRepositorioTestContainer {

    @Autowired
    ProductoRepositorio repositorio;


    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer(DockerImageName.parse("postgres:16-alpine"))
            .withUsername("testUser")
            .withPassword("testSecret")
            .withDatabaseName("testDatabase");



    @Test
    //@Sql("classpath:insert-product.sql")
    void precioMenorQue() {
        List<Producto> resultado = repositorio.findByPrecioLessThan(10);

        assertEquals(1, resultado.size());
        assertEquals(8, resultado.get(0).getPrecio());
        assertEquals("Producto 1", resultado.get(0).getNombre());
    }

    @Test
    //@Sql("classpath:insert-product.sql")
    void findAll() {
        assertEquals(3, repositorio.count());
        assertEquals(3, repositorio.findAll().size());
    }

    //@AfterEach
    //void tearDown() {
    //    repositorio.deleteAll();
    //}







}
