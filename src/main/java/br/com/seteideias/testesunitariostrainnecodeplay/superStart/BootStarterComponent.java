package br.com.seteideias.testesunitariostrainnecodeplay.superStart;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStarterComponent implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {


        String jString = "{\"nome\" : \"Carlos Pijanowski\"}";

        JSONObject jObject = null;
        jObject = new JSONObject(jString);
        JSONObject geoObject = jObject.getJSONObject("cliente");

        final String nome = geoObject.getString("nome");

        System.out.println("*********************** nome");
    }


    public static void main(String[] args)   {

        try {
            String str = "{\"nome\":\"John\",\"age\":\"30\"}";
            JSONObject jsonObject = new JSONObject(str);
            System.out.println("OBJECT : "+jsonObject.toString());

            ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
            Cliente cliente = mapper.convertValue(jsonObject, Cliente.class);
            System.out.println(cliente.nome);//TODO RETOMAR AQUI

        } catch (JSONException err) {
            System.out.println("Exception : "+err.toString());
        }




    }

    @Data
    public static class Cliente {
        String nome;
        String age;
    }

}
