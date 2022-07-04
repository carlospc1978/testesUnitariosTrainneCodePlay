package br.com.seteideias.testesunitariostrainnecodeplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TestesUnitariosTrainneCodePlayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestesUnitariosTrainneCodePlayApplication.class, args);
    }

}
