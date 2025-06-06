/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.dao;

import br.com.scep.model.Login;
import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author jeffe_cjks0ez
 */
public class LoginDao {
    
       public boolean loginCheck(Login l) throws SQLException {
        String sql = "SELECT * FROM login WHERE cpf = ? AND senha = ?";
        Connection conn = getCon();
        boolean check = false;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getCpf());
            stmt.setString(2, l.getSenha());
            ResultSet rs = stmt.executeQuery();
            
             
            
        if (rs.next()) {
            check = true;
            System.out.println("ACESSO LIBERADO: " + l.toString());
            return check;
            } else {
            check = false;
            System.err.println("ACESSO NEGADO: ");
             return check;
            }
            
        } finally {
            conn.close();
        }
    }
   

   }

