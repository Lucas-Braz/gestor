package com.agroHabil.gestor.Controller;

import com.agroHabil.gestor.Model.M_Resposta;
import com.agroHabil.gestor.Service.S_Cad_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Cadastro {
    @GetMapping("/cadUsuario")
    public String getCadUsuario(){
        return "Usuario/cadastro";
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
