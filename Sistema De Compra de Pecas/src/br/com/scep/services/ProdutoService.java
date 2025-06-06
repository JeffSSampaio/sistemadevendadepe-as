/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.services;

import br.com.scep.dao.ProdutoDao;
import br.com.scep.model.Produto;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author jeffe_cjks0ez
 */
public class ProdutoService {
  

  






 public Produto criarProdutoModel(String nomeProd, double precoProd, int idProd) {
    Produto prod = new Produto();
    prod.setNomeProd(nomeProd);
    prod.setValor_Produto(precoProd);
    prod.setId(idProd);
    return prod;
}



    
    public boolean camposNaoVazios(JTextField nomeProdField, JTextField quantProdField, JTextField preceProdField) {
        return !nomeProdField.getText().isEmpty() && 
               !quantProdField.getText().isEmpty() && 
               !preceProdField.getText().isEmpty();
    }
}


