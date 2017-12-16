package com.example.soren5.myfirstapp;

/**
 * Created by soren5 on 12/13/17.
 */

public class Pedido {
    public String getNome() {
        return nome;
    }

    public String getNome2() {
        return nome2;
    }

    public Pedido(String nome, String nome2) {
        this.nome = nome;
        this.nome2 = nome2;
    }

    private String nome;
    private String nome2;
}
