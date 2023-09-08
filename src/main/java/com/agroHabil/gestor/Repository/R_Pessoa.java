package com.agroHabil.gestor.Repository;

import com.agroHabil.gestor.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
    @Query(value="select * from pessoa where cpf_cnpj = :cpf_cnpj and senha = :senha",nativeQuery = true)
    M_Pessoa buscarPessoaPorUsuarioESenha(@Param("cpf_cnpj") Long cpf_cnpj, @Param("senha") String senha);
}
