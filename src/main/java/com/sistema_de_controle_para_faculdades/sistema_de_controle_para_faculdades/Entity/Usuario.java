package com.sistema_de_controle_para_faculdades.sistema_de_controle_para_faculdades.Entity;

public class Usuario {
    final private String nome;
    final private String senha;

    // Construtor padrão que lê os dados do arquivo
    public Usuario() {
        this.nome = "leonardo";
        this.senha = "admin123";
    }

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }
}
