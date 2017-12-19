package com.example.soren5.taximate;

/**
 * Created by soren5 on 12/13/17.
 */

public class Pedido {
    private String requestID;
    private String userID;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    private String de;
    private String para;
    private String cidade;
    private String data;
    private String hora;


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

    public Pedido() {
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Pedido(String requestID, String userID, String de, String para, String cidade, String data, String hora) {

        this.requestID = requestID;
        this.userID = userID;
        this.de = de;
        this.para = para;
        this.cidade = cidade;
        this.data = data;
        this.hora = hora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "requestID='" + requestID + '\'' +
                ", userID='" + userID + '\'' +
                ", nome='" + nome + '\'' +
                ", de='" + de + '\'' +
                ", para='" + para + '\'' +
                ", cidade='" + cidade + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Pedido(String requestID, String userID, String nome, String de, String para, String cidade, String data, String hora) {
        this.requestID = requestID;
        this.userID = userID;
        this.nome = nome;
        this.de = de;
        this.para = para;
        this.cidade = cidade;
        this.data = data;
        this.hora = hora;
    }
}
