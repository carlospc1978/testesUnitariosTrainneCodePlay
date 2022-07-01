package br.com.seteideias.testesunitariostrainnecodeplay.controller;

import br.com.seteideias.testesunitariostrainnecodeplay.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    Calculator calculator;

    @GetMapping("/sum/{num1}/{num2}")
    public ResponseEntity<Double> deveSomar(@PathVariable double num1,
                                            @PathVariable double num2) {


        Double sum = calculator.sum(num1, num2);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sum);

    }

}
