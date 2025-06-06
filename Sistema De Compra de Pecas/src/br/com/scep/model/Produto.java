/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.model;

/**
 *
 * @author jeffe_cjks0ez
 */
public class Produto {
    private int id;
    private String nomeProd;
    private double valor_Produto;

    public Produto(int id, String nomeProd, double valor_Produto) {
        this.id = id;
        this.nomeProd = nomeProd;
        this.valor_Produto = valor_Produto;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nomeProd=" + nomeProd + ", valor_Produto=" + valor_Produto + '}';
    }

    public Produto(String nomeProd, double valor_Produto) {
        this.nomeProd = nomeProd;
        this.valor_Produto = valor_Produto;
    }

    public Produto() {
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getValor_Produto() {
        return valor_Produto;
    }

    public void setValor_Produto(double valor_Produto) {
        this.valor_Produto = valor_Produto;
    }
    
    
}
