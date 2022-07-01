package br.com.seteideias.testesunitariostrainnecodeplay.service;

import br.com.seteideias.testesunitariostrainnecodeplay.model.service.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {

    @Autowired
    OperacoesNoBancoDeDados operacoesNoBancoDeDados;

    public void alugaAUmCliente (Filme filme) throws Exception {

        if (!filme.isDisponivelParaLocacao()) {
            throw new Exception("indisponivel para locação");
        }

        if (calculaEstoqueDisponivel(filme)) {
            operacoesNoBancoDeDados.grava(filme);
        }

    }

    private boolean calculaEstoqueDisponivel(Filme filme) {
        return operacoesNoBancoDeDados.calculaDisponibilidade(filme);
    }

}
