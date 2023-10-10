package com.agroHabil.gestor.Controller;

import com.agroHabil.gestor.Model.M_Pessoa;
import com.agroHabil.gestor.Service.S_Login;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {
    @GetMapping("/")
    public String landPage(HttpServletRequest request){
        return "Login/login";
    }

    @PostMapping("/")
    public String login(@RequestParam("cpf_cnpj") String cpf_cnpj,
                        @RequestParam("senha") String senha,
                        Model model){
        M_Pessoa pessoa = S_Login.checarLogin(cpf_cnpj, senha);
        if(pessoa == null){
            return "Login/login";
        }else{
            model.addAttribute("nome", "Bem Vindo(a) " + pessoa.getNome());
            return "Home/home";
        }
    }
}
