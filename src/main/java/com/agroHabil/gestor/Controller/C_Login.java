package com.agroHabil.gestor.Controller;

import com.agroHabil.gestor.Service.S_Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {
    @GetMapping("/")
    public String landPage(){
        return "Login/login";
    }

    @PostMapping("/")
    public String login(@RequestParam("cpf_cnpj") String cpf_cnpj,@RequestParam("senha") String senha){
        if(S_Login.checarLogin(cpf_cnpj, senha) == null){
            return "Login/login";
        }else{
            return "Home/home";
        }
    }
}
