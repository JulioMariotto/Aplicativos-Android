package com.example.matematicadivertida;

import android.graphics.Bitmap;

public class Pergunta {

    private int cod;
    private String pergunta;
    private String[] respostas;
    private int certa;
    private Integer idFoto;

    public Pergunta(int cod, String pergunta, String[] respostas, int certa, Integer idFoto) {
        this.cod = cod;
        this.pergunta = pergunta;
        this.respostas = respostas;
        this.certa = certa;
        this.idFoto = idFoto;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }

    public int getCerta() {
        return certa;
    }

    public void setCerta(int certa) {
        this.certa = certa;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }
}
