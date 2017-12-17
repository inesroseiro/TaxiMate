package com.example.soren5.taximate;

/**
 * Created by soren5 on 12/13/17.
 */

public class Pedido {
    private String nome;
    private String apelido;
    private String de;
    private String para;

    public Pedido(String nome, String apelido, String de, String para, String dataLocal) {
        this.nome = nome;
        this.apelido = apelido;
        this.de = de;
        this.para = para;
        this.dataLocal = dataLocal;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(String dataLocal) {
        this.dataLocal = dataLocal;
    }

    private String dataLocal;

    public String getNome() {
        return nome;
    }

    public String getNome2() {
        return apelido;
    }

    public Pedido(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
    }

}
