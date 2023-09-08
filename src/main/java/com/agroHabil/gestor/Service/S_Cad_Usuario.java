package com.agroHabil.gestor.Service;

import com.agroHabil.gestor.Model.M_Pessoa;
import com.agroHabil.gestor.Model.M_Resposta;
import com.agroHabil.gestor.Repository.R_Pessoa;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Cad_Usuario {
    private static R_Pessoa r_pessoa;

    public S_Cad_Usuario(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static M_Resposta salvarCadastro(String nome, String cpf_cnpj, String email,
                                     String telefone, String senha, String conf_senha){
        boolean podeSalvar = true;
        String mensagem = "";

        if(nome == null || nome.equals("")){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if((email == null || email.equals("")) && (telefone == null || telefone.equals(""))){
            podeSalvar = false;
            mensagem += "É necessário informar um email ou telefone!";
        }
        if(!S_CPF.validarCPF(cpf_cnpj)){
            podeSalvar = false;
            mensagem += "O CPF informado é inválido!";
        }
        if(senha == null || senha.equals("")){
            podeSalvar = false;
            mensagem += "É necessário informar uma senha!";
        }else if(!senha.equals(conf_senha)){
            mensagem += "A senha e a confirmação de senha precisam ser iguais!";
        }
        if(podeSalvar){
            M_Pessoa m_pessoa = new M_Pessoa();
            m_pessoa.setNome(nome);
            m_pessoa.setCpf_cnpj(Long.parseLong(S_CPF.limparNumero(cpf_cnpj)));
            m_pessoa.setEmail(email);
            m_pessoa.setTelefone(telefone);
            m_pessoa.setSenha(senha);
            try {
                r_pessoa.save(m_pessoa);
                mensagem += "Cadastro realizado com sucesso!";
            }catch (DataIntegrityViolationException e){
                podeSalvar = false;
                mensagem += "Falha ao incluir registro no banco de dados.";
            }
        }
        return new M_Resposta(podeSalvar,mensagem);
    }
}
