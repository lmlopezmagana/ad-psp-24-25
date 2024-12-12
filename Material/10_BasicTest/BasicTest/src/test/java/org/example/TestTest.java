package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTest {

    @BeforeAll
    static void initAll() {
        System.out.println("Al principio de todo");
    }

    @BeforeEach
    void init() {
        System.out.println("Antes de cada test");
    }

    @Test
    void test() {
        System.out.println("Test");
        assertTrue(true);
    }

    @Test
    void test2() {
        System.out.println("Test 2");
        assertTrue(true);
    }
    @Test
    @Disabled
    void test_disabled() {
        System.out.println("Test deshabilitado");
        assertTrue(true);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Después de cada test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Al final del todo");
    }


}
