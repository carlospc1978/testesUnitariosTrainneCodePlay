package br.com.seteideias.testesunitariostrainnecodeplay.controller;

import br.com.seteideias.testesunitariostrainnecodeplay.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ChamarNGrokEMockonServidorRemoto {

    @Autowired
    private UsuarioClient usuarioClient;

    @GetMapping
    public String buscar() throws URISyntaxException {
//    public ResponseEntity<String> buscar() throws URISyntaxException {

        URI uri = new URI("https://014d-201-148-254-77.sa.ngrok.io/forward-and-record");
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response
                = restTemplate.getForEntity(uri, String.class);


        final String s = this.usuarioClient.bucarNaURIAcima();


        System.out.println(" ->>>>>>>>>>>>>>>>>>>>>>>> "+s);

        String body = response.getBody() + "**** "+ s;

        return body;
//        return response;

    }

}
