package br.com.seteideias.testesunitariostrainnecodeplay.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void deveRetornarZeroSeNaoPassarNumero() {

        Calculator calculator = new Calculator();

        double sum = calculator.sum();

        Assertions.assertEquals(0,sum);

    }

    @Test
    void deveRetornarUmaSoma() {

        Calculator calculator = new Calculator();

        double sum = calculator.sum(5,4);

        Assertions.assertEquals(9,sum);

    }

    @Test
    void deveFuncionarARaizQuadrada() {

        Calculator calculator = new Calculator();

        double v = calculator.squareRoot(4);

        Assertions.assertEquals(2,v);

    }

    @Test
    void deveLancarExcecaoSeOnumeroForMenorQueZero() {

        Calculator calculator = new Calculator();

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1));

        Assertions.assertEquals("um numero negativo nao tem raiz quadrada", illegalArgumentException.getMessage());

    }

    @Test
    void ehUmNumeroPar() {

        Calculator calculator = new Calculator();

        boolean odd = calculator.isOdd(4);

        Assertions.assertFalse(odd);

    }


    @Test
    void ehUmNumeroImpar() {

        Calculator calculator = new Calculator();

        boolean odd = calculator.isOdd(3);

        Assertions.assertTrue(odd);

    }
}