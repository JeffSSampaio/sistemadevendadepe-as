/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.model;

import java.util.List;

/**
 *
 * @author jeffe_cjks0ez
 */
public class Estoque {

    private long id;
    private long idProduto;
    private String nomeProduto;
    private int quantidade;
    private double valorProduto;
    
    private List<Estoque> estoque;
 
    
    public Estoque(long id, long idProduto, String nomeProduto, int quantidade, double valorProduto) {
        this.id = id;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
    }

    public Estoque(String nomeProduto, int quantidade, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
    }

    public Estoque() {
    }

    public List<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        this.estoque = estoque;
    }

   
    
 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString() {
        return "Estoque [id=" + id + ", idProduto=" + idProduto + ", nomeProduto=" + nomeProduto +
               ", quantidade=" + quantidade + ", valorProduto=" + valorProduto + "]";
    }
}

