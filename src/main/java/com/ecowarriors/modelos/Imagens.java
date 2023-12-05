/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecowarriors.modelos;

/**
 *
 * @author Lenovo
 */
public class Imagens {
    
    private String hashImagem;
    private String caminhoImagem;
    private String protocolo;

    public String getHashImagem() {
        return hashImagem;
    }

    public void setHashImagem(String hashImagem) {
        this.hashImagem = hashImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Imagens(String hashImagem, String caminhoImagem, String protocolo) {
        this.hashImagem = hashImagem;
        this.caminhoImagem = caminhoImagem;
        this.protocolo = protocolo;
    }
   
    public Imagens (){
        
    }
   
    
}
