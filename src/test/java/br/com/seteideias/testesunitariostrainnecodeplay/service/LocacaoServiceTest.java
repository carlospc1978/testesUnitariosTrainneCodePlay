package br.com.seteideias.testesunitariostrainnecodeplay.service;

import br.com.seteideias.testesunitariostrainnecodeplay.model.service.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocacaoServiceTest {

    @Mock
    OperacoesNoBancoDeDados operacoesNoBancoDeDados;

    @InjectMocks
    LocacaoService locacaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void alugaComSucessoSeEstiverDisponivelParaLocacao () {

        //cenario

        Filme filme = new Filme();
        filme.setNomeDoFilme("Duro de matar 2");
        filme.setDisponivelParaLocacao(true);

        when(operacoesNoBancoDeDados.calculaDisponibilidade(filme)).thenReturn(true);

        //acao
        operacoesNoBancoDeDados.grava(filme);
        //verificacao
        verify(operacoesNoBancoDeDados, times(1)).grava(filme);

    }

    @Test
    void nao_AlugaComSucessoSeEstiverDisponivelParaLocacao () {

        //cenario

        Filme filme = new Filme();
        filme.setNomeDoFilme("Duro de matar 3 - ainda nao lancado");
        filme.setDisponivelParaLocacao(false);

        when(operacoesNoBancoDeDados.calculaDisponibilidade(filme)).thenReturn(false);

        //acao
        doNothing().when(operacoesNoBancoDeDados).grava(filme);
        //verificacao
        verify(operacoesNoBancoDeDados, times(0)).grava(filme);

    }
}