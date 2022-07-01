package br.com.seteideias.testesunitariostrainnecodeplay.service;

import br.com.seteideias.testesunitariostrainnecodeplay.model.service.Filme;
import org.springframework.stereotype.Component;

@Component
public class OperacoesNoBancoDeDados {

    public void grava(Filme filme){
        System.out.println("chamou o metodo real... isso nao deve acontecer");
    }

    public boolean calculaDisponibilidade (Filme filme){
        return true;
    }

}
