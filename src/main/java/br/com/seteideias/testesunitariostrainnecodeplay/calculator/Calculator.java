package br.com.seteideias.testesunitariostrainnecodeplay.calculator;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public double sum(double... numbers) {
        double sum = 0;

        if (numbers.length > 0) {
            for (double number : numbers) {
                sum += number;
            }
        }
        return sum;

    }

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("um numero negativo nao tem raiz quadrada");
        }
        return Math.sqrt(number);
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

}
