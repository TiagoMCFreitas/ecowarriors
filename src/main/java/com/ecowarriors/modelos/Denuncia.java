package com.ecowarriors.modelos;

import java.io.File;
import java.sql.Date;
import com.ecowarriors.Enum.Categoria;

public class Denuncia {

    private String id;
    private File foto = new File("");
    private String denuciante;
    private Endereco enderecoIncidente;
    private String descricaoIncidente;
    private Categoria categoria; 
    private Date data;
    private String AutorCrime;

    public Denuncia() {
    }
    

    public Denuncia(String id, File foto, String denunciante, Endereco enderecoIncidente, String descricaoIncidente, Categoria categoria, Date data, String AutorCrime) {
        this.id = id;
        this.foto = foto;
        this.denuciante = denunciante;
        this.enderecoIncidente = enderecoIncidente;
        this.descricaoIncidente = descricaoIncidente;
        this.categoria = categoria;
        this.data = data;
        this.AutorCrime = AutorCrime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public File getFoto() {
        return foto;
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

    public Endereco getEndereco() {
        return enderecoIncidente;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecoIncidente = endereco;
    }

    public String getDescricao() {
        return descricaoIncidente;
    }

    public void setDescricao(String descricao) {
        this.descricaoIncidente = descricao;
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
