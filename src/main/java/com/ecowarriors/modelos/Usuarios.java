package com.ecowarriors.modelos;

import com.ecowarriors.Enum.Usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "usuarios")  // Nome da tabela no banco de dados
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Se seu ID for autoincrementável, você pode usar Long
    private String cpf;
    private String senha;
    private String nome;
    private String email;
    private Usuario tipoUsuario;
    private String telefone;

    public Usuarios() {
    }

    public Usuarios(String cpf, String senha, String nome, String email, Usuario tipoUsuario, String telefone) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.telefone = telefone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Usuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Usuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
