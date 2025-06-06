/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.dao;

import br.com.scep.model.Vendas;
import java.sql.Connection;
import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.CallableStatement;
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jeffe_cjks0ez
 */
public class VendaDao {
    public void fazerVenda(Vendas v) throws SQLException {
    String sql = "{CALL FazerVenda(?, ?, ?)}";
    try (Connection conn = getCon();
         CallableStatement stmt = conn.prepareCall(sql)) {

        System.out.println("Conexão com o banco de dados estabelecida.");

        // Configura os parâmetros da chamada de procedimento armazenado
        stmt.setString(1, v.getNomeCliente());
        stmt.setInt(2, v.getId_produto());
        stmt.setInt(3, v.getQuantidade());

        System.out.println("Parâmetros configurados: " + v.getNomeCliente() + ", " + v.getId_produto() + ", " + v.getQuantidade());

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Venda realizada com sucesso.");
            System.out.println(v.toString());
             JOptionPane.showMessageDialog(null, "Venda Realizada - Produto" + v.getNomeProduto() );
        } else {
            System.out.println("Nenhuma venda realizada. Verifique os dados informados.");
             JOptionPane.showMessageDialog(null, "Nenhuma Venda Realizada - Produto" + v.getNomeProduto() );
        }
    } catch (SQLException e) {
        System.err.println("Erro ao executar o procedimento armazenado: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "EROO AO EXECUTAR PROCEDIMENTO ARMAZENADO " );
    }
}




}
    
    
