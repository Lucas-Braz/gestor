package com.agroHabil.gestor.Controller;

import com.agroHabil.gestor.Model.M_Resposta;
import com.agroHabil.gestor.Service.S_Cad_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class C_Cadastro {
    @GetMapping("/cadUsuario")
    public String getCadUsuario(HttpServletRequest request){
        String referer = request.getHeader("Referer");
        if(referer != null) {
            return "Usuario/cadastro";
        }else{
            return "/error";
        }
    }

    @PostMapping("/cadUsuario")
    @ResponseBody
    public M_Resposta postCadUsuario(@RequestParam("nome") String nome,
                                 @RequestParam("cpf_cnpj") String cpf_cnpj,
                                 @RequestParam("email") String email,
                                 @RequestParam("telefone") String telefone,
                                 @RequestParam("senha") String senha,
                                 @RequestParam("conf_senha") String conf_senha){
         return S_Cad_Usuario.salvarCadastro(nome, cpf_cnpj, email, telefone, senha, conf_senha);
    }
}
