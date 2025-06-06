/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.model;

/**
 *
 * @author jeffe_cjks0ez
 */
public class Vendas {
    private int id;
    private int id_produto;
    private String nomeCliente;
    private String nomeProduto;
    private int quantidade;
    private double valor_produto;
    private double valor_total;

    public Vendas(int id_produto, String nomeCliente, int quantidade, double valor_produto, double valor_total) {
        this.id_produto = id_produto;
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.valor_produto = valor_produto;
        this.valor_total = valor_total;
    }

    public Vendas(int id_produto, String nomeCliente, int quantidade, double valor_total) {
        this.id_produto = id_produto;
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }

    public Vendas(int id_produto, String nomeCliente, String nomeProduto, int quantidade, double valor_total) {
        this.id_produto = id_produto;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }

    public Vendas() {
    }
    
    

    @Override
    public String toString() {
        return "Vendas{" + "id=" + id_produto + ", nomeCliente=" + nomeCliente + ", quantidade=" + quantidade + ", valor_produto=" + valor_produto + ", valor_total=" + valor_total + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    
    


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(double valor_produto) {
        this.valor_produto = valor_produto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    
    
    
}
