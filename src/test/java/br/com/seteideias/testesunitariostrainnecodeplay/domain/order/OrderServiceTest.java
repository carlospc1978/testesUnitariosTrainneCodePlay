package br.com.seteideias.testesunitariostrainnecodeplay.domain.order;

import br.com.seteideias.testesunitariostrainnecodeplay.domain.payment.PaymentService;
import br.com.seteideias.testesunitariostrainnecodeplay.domain.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class OrderServiceTest {

    @Mock
    private UserService userService;
    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deveLancarExcecaoSeForMenorDeIdade() {

        Mockito.when(userService.isUserMinor(15L)).thenReturn(true);

        Mockito.doNothing().when(paymentService).pay();

        Order order = new Order(15L);

        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> orderService.create(order));

        Assertions.assertEquals("menor de idade",illegalStateException.getMessage());

        Mockito.verify(userService, Mockito.atLeastOnce()).isUserMinor(any());
        Mockito.verify(paymentService,Mockito.atLeast(0)).pay();

    }

    @Test
    void criarOrdemSeMaiorDeIdade(){

        Mockito.when(userService.isUserMinor(18L)).thenReturn(false);
        Mockito.doNothing().when(paymentService).pay();

        orderService.create(new Order(18L));

        Mockito.verify(userService, Mockito.atLeastOnce()).isUserMinor(any());
        Mockito.verify(paymentService,Mockito.atLeastOnce()).pay();

    }

    @Test
    void estornarPagamento(){

        Mockito.when(userService.isUserMinor(101L)).thenReturn(true);

        Order order = new Order(101L);

        orderService.extornarPagamento(order);

    }

}