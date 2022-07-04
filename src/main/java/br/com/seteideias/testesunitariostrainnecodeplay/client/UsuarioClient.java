package br.com.seteideias.testesunitariostrainnecodeplay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://014d-201-148-254-77.sa.ngrok.io/", name = "usuario")
//@FeignClient(url = "http://localhost:8085/usuario/", name = "usuario")
public interface UsuarioClient {

    @GetMapping("forward-and-record")
    String bucarNaURIAcima();
//    Usuario buscaPeloEmail(@PathVariable("email") String email);
}
