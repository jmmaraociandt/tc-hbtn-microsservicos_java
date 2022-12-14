package demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {
    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login")
    public String login(String user, String password) {
        String msgToReturn;

        if (user.isEmpty() && password.isEmpty())
            msgToReturn = "USUÁRIO E SENHA NÃO INFORMADOS";
        else if (user.length() > 15 && password.length() > 15)
            msgToReturn = "USUÁRIO E SENHA INVÁLIDOS";
        else
            msgToReturn = "LOGIN EFETUADO COM SUCESSO !!!";

        return msgToReturn;
    }
}
