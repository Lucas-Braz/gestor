package com.agroHabil.gestor.Model;

public class M_Resposta {
    private boolean sucesso;
    private String mensagem;
    private String paginaEstatica;

    public M_Resposta(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPaginaEstatica() {
        return paginaEstatica;
    }

    public void setPaginaEstatica(String paginaEstatica) {
        this.paginaEstatica = paginaEstatica;
    }
}
