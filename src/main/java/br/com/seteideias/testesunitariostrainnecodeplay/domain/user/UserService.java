package br.com.seteideias.testesunitariostrainnecodeplay.domain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isUserMinor(Long idade) {

        if (idade >= 18) {
            return false;
        }

        return true;
    }

}
