/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.services;

import br.com.scep.model.Vendas;
import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;

/**
 *
 * @author jeffe_cjks0ez
 */
public class VendasService {

    public void buscarProduto(JTextField idItem, JTextPane jTextPaneProduto) {

        Connection conn = getCon();
        try {
            String query = "SELECT nome_produto FROM produto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(idItem.getText()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomeProduto = rs.getString("nome_produto");
                jTextPaneProduto.setText(nomeProduto);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encotrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CalcularValorTotal(JTextField idItem, JTextField quant, JTextPane valorTotal) {

        Connection conn = getCon();
        try {
            String query = "SELECT valor_produto FROM produto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(idItem.getText()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double vlrTotal = rs.getDouble("valor_produto") * Double.parseDouble(quant.getText());

                valorTotal.setText(Double.toString(vlrTotal));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivél calcular valor total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean camposNaoVazios(JTextField idItemProdField) {
        return !idItemProdField.getText().isEmpty();
    }

    public boolean camposNaoVazios(JTextField idProdField, JTextField clienteProdField, JTextPane jTextPaneProduto, JTextField qtnProdField, JTextPane valorTotalProdField) {
        return !clienteProdField.getText().isEmpty()
                && !idProdField.getText().isEmpty()
                && !qtnProdField.getText().isEmpty()
                && !valorTotalProdField.getText().isEmpty()
                && !jTextPaneProduto.getText().isEmpty();
    }

    public List<Vendas> consultarRelatorioVendas() {
        String sql = "SELECT * FROM RelatorioVendas";
        List<Vendas> listaDeVendas = new ArrayList<>();
        try (Connection conn = getCon(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            System.out.println("Relatorio De Vendas");
            while (rs.next()) {
                
                Vendas v = new Vendas();
                
                int vendaID = rs.getInt("VendaID");
                String cliente = rs.getString("Cliente");
                String produto = rs.getString("Produto");
                int quantidade = rs.getInt("Quantidade");
                double valorTotal = rs.getDouble("ValorTotal");
                
                v.setId(vendaID);
                v.setNomeCliente(cliente);
                v.setNomeProduto(produto);
                v.setQuantidade(quantidade);
                v.setValor_total(valorTotal);
                
                listaDeVendas.add(v);
                System.out.println(listaDeVendas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------");
        return listaDeVendas;
    }

}
