package com.ecowarriros.modelos;

public class Usuarios {

    private String id;
    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private String tipoUsuario;
    private String telefone;

    public Usuarios() {
    }

    public Usuarios(String id, String cpf, String senha, String nome, String email, String tipoUsuario, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
