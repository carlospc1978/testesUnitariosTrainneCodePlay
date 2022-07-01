package br.com.seteideias.testesunitariostrainnecodeplay.controller;

import br.com.seteideias.testesunitariostrainnecodeplay.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @Mock
    Calculator calculator;

    @InjectMocks
    CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveSomar() {


        Mockito.when(calculator.sum(Mockito.any())).thenReturn(10.00);

        double sum = calculator.sum(10.00);

        Mockito.verify(calculator,Mockito.atLeastOnce()).sum(Mockito.any());

        Assertions.assertEquals(10.00,sum);

    }
}