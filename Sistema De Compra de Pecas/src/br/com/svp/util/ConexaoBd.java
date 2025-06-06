/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.svp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {

    private static final String url = "jdbc:mysql://localhost:3306/estoque_Supermercado";
    private static final String usuario= "root";
    private static final String senha = "";

    public static Connection getCon(){
      Connection conn = null;
        try {
            // Registrar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retornar a conexão
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException erro) {
            System.err.println("Erro ao conectar ao banco de dados: " + erro.getMessage());
            erro.printStackTrace();
        } catch (ClassNotFoundException erro) {
            System.err.println("Driver JDBC do MySQL não encontrado: " + erro.getMessage());
            erro.printStackTrace();
        }
        
        return conn ;
    }
    
    
  public static void verificarConn(){
         try (Connection conn = getCon()) {
            if (conn != null) {
                System.out.println("BANCO DE DADOS CONECTADO");
            } else {
                System.err.println("ERRO EM CONECTAR");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
}
  
}
