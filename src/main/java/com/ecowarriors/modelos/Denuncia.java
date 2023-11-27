package com.ecowarriors.modelos;

import java.io.File;
import java.sql.Date;
import com.ecowarriors.Enum.Categoria;

public class Denuncia {

    private String id;
    private String protocolo;
    private File foto = new File("");
    private String denuciante;
    private Endereco enderecoIncidente;
    private String descricaoIncidente;
    private Categoria categoria; 
    private Date data;
    private String AutorCrime;

    public Denuncia() {
    }
    

    public Denuncia(String protocolo, File foto, String denunciante, Endereco enderecoIncidente, String descricaoIncidente, Categoria categoria, Date data, String AutorCrime) {
        this.id = id;
        this.protocolo = protocolo;
        this.foto = foto;
        this.denuciante = denunciante;
        this.enderecoIncidente = enderecoIncidente;
        this.descricaoIncidente = descricaoIncidente;
        this.categoria = categoria;
        this.data = data;
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
