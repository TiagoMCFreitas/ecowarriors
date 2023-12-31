package com.ecowarriors.modelos;

public class Endereco {
    private int id;
    private String rua;
    private String bairro;
    private String municipio;
    private String CEP;
    private String pontoReferencia;
    
    public Endereco(){}
    public Endereco( String rua, String bairro, String municipio, String CEP, String pontoReferencia){
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
        this.CEP = CEP;
        this.pontoReferencia = pontoReferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }
    
}
