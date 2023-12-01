package com.ecowarriors.modelos;

import java.io.File;
import java.sql.Date;
import com.ecowarriors.Enum.Categoria;
import com.ecowarriors.Enum.StatusDenuncia;

public class Denuncia {

    private String id;
    private String protocolo;
    private File foto = new File("");
    private String denuciante;
    private Endereco enderecoIncidente;
    private String descricaoIncidente;
    private StatusDenuncia statusDenuncia;
    private Categoria categoria; 
    private Date data;
    private String AutorCrime;

    public Denuncia() {
    }
    

    public Denuncia(String protocolo, File foto, String denunciante, Endereco enderecoIncidente, String descricaoIncidente, Categoria categoria, Date data, String AutorCrime, StatusDenuncia statusDenuncia) {
        this.protocolo = protocolo;
        this.foto = foto;
        this.statusDenuncia  = StatusDenuncia.CRIADA;
        this.denuciante = denunciante;
        this.enderecoIncidente = enderecoIncidente;
        this.descricaoIncidente = descricaoIncidente;
        this.categoria = categoria;
        this.AutorCrime = AutorCrime;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Endereco getEnderecoIncidente() {
        return enderecoIncidente;
    }

    public void setEnderecoIncidente(Endereco enderecoIncidente) {
        this.enderecoIncidente = enderecoIncidente;
    }

    public String getDescricaoIncidente() {
        return descricaoIncidente;
    }

    public void setDescricaoIncidente(String descricaoIncidente) {
        this.descricaoIncidente = descricaoIncidente;
    }

    public File getFoto() {
        return foto;
    }

    public StatusDenuncia getStatusDenuncia() {
        return statusDenuncia;
    }

    public void setStatusDenuncia(StatusDenuncia statusDenuncia) {
        this.statusDenuncia = statusDenuncia;
    }

    public void setFoto(File foto) {
        this.foto = foto;
    }
    
    public String getDenuciante() {
        return denuciante;
    }

    public void setDenuciante(String denuciante) {
        this.denuciante = denuciante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAutorCrime() {
        return AutorCrime;
    }

    public void setAutorCrime(String AutorCrime) {
        this.AutorCrime = AutorCrime;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "id=" + id + ", denuciante=" + denuciante + ", endereco=" + enderecoIncidente + ", descricao=" + descricaoIncidente + ", categoria=" + categoria + ", data=" + data + ", AutorCrime=" + AutorCrime + '}';
    }
    
}
