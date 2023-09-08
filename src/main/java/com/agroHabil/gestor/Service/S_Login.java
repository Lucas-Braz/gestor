package com.agroHabil.gestor.Service;

import com.agroHabil.gestor.Model.M_Pessoa;
import com.agroHabil.gestor.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class S_Login {
    private static R_Pessoa r_pessoa;

    public S_Login(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Pessoa checarLogin(String cpf_cnpj, String senha){
        return r_pessoa.buscarPessoaPorUsuarioESenha(Long.parseLong(S_CPF.limparNumero(cpf_cnpj)), senha);
    }
}
