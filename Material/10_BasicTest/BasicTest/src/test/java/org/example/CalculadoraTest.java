package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {


    @AfterEach
    void setUp() {
        System.out.println("Ho ho ho");
    }

    @Test
    @DisplayName("1+1=2")
    void sumarDosNumeros() {
        Calculadora c = new Calculadora();
        int esperado = 2;
        assertEquals(esperado, c.sumar(1,1));
    }


    @ParameterizedTest
    @CsvSource({
          "1,1,2",
          "0,1,1",
          "-1,1,0"
    })
    void sumarDosNumerosParametrizado(int a, int b, int resultado) {
        Calculadora c = new Calculadora();
        assertEquals(resultado, c.sumar(a,b));
    }

}
