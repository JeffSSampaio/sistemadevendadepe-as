/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.services;

import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import br.com.scep.model.Estoque;

/**
 *
 * @author jeffe_cjks0ez
 */
public class EstoqueService {



    public List<Estoque> gerarRelatorioEstoque() {
        List<Estoque> listaEstoque = new ArrayList<>();
        String sql = "SELECT \n"
                + "    Estoque.id_produto AS EstoqueID,\n"
                + "    Produto.nome_produto AS NomeProduto,\n"
                + "    Estoque.quantidade AS Quantidade,\n"
                + "    Estoque.valor_produto AS ValorProduto\n"
                + "FROM \n"
                + "    Estoque\n"
                + "JOIN \n"
                + "    Produto ON Estoque.id_produto = Produto.id;";

        try (Connection conn = getCon(); 
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estoque item = new Estoque();
                item.setId(rs.getInt("EstoqueID"));
                item.setNomeProduto(rs.getString("NomeProduto"));
                item.setQuantidade(rs.getInt("Quantidade"));
                item.setValorProduto(rs.getDouble("ValorProduto"));
                listaEstoque.add(item);
                item.setEstoque(listaEstoque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEstoque;
    }

public void limparCampos(){
  
}


   
}
