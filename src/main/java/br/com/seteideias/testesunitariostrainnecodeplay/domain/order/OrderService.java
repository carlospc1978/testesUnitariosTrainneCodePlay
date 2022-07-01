package br.com.seteideias.testesunitariostrainnecodeplay.domain.order;

import br.com.seteideias.testesunitariostrainnecodeplay.domain.payment.PaymentService;
import br.com.seteideias.testesunitariostrainnecodeplay.domain.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private UserService userService;
    private PaymentService paymentService;

    public OrderService(UserService userService, PaymentService paymentService) {
        this.userService = userService;
        this.paymentService = paymentService;
    }

    public void create(Order order){

        boolean isUserMinor = userService.isUserMinor(order.getUserId());

        if(isUserMinor){
            throw new IllegalStateException("menor de idade");
        }

        paymentService.pay();

    }

    public void extornarPagamento(Order order){

        if(order.getUserId() >= 100L){
            paymentService.estorno();
        }
    }


}
