/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.scep.dao; 
import br.com.scep.model.Produto; 
import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jeffe_cjks0ez
 */
public class ProdutoDao {
    
    private ProdutoDao dao;


public Produto cadastrarProduto(Produto produto, int quantidade) throws SQLException {
    String sql = "{CALL CadastrarProduto(?, ?, ?)}";
    String sqlObterId = "SELECT LAST_INSERT_ID()";
    
    try (Connection conn = getCon();
         CallableStatement stmt = conn.prepareCall(sql);
         PreparedStatement stmtId = conn.prepareStatement(sqlObterId)) {

        // Configura os parâmetros da chamada de procedimento armazenado
        stmt.setString(1, produto.getNomeProd());
        stmt.setDouble(2, produto.getValor_Produto());
        stmt.setInt(3, quantidade);

        // Executa a inserção
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            // Recupera o ID gerado
            ResultSet rs = stmtId.executeQuery(); 
            int idProd = 0;
            if (rs.next()) { 
                idProd = rs.getInt(1); 
            }

            System.out.println("Produto cadastrado com sucesso. ID: " + idProd);
            produto.setId(idProd); // Atribui o ID ao objeto Produto
            return produto; // Retorna o produto com o ID atualizado
        } else {
            System.out.println("Nenhum produto encontrado com o ID especificado.");
            return null;
        }
        
    } catch (SQLException e) {
        System.err.println("Não foi possível cadastrar o produto - " + e.getMessage());
        throw e;
    }
}





    
 public void atualizarProd(Produto prod) {
    String sqlProd = "UPDATE produto SET nome_produto = ?, valor_produto = ? WHERE id = ?";
    String sqlEstoque = "UPDATE estoque SET  valor_produto = ? WHERE id_produto = ?";
    try (Connection conn = getCon();
         PreparedStatement stmt = conn.prepareStatement(sqlProd);
         PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque)
            )
    {
        stmt.setString(1, prod.getNomeProd());
        stmt.setDouble(2, prod.getValor_Produto());
        stmt.setInt(3, prod.getId());

        stmtEstoque.setDouble(1, prod.getValor_Produto());
        stmtEstoque.setInt(2, prod.getId());
   
        int rowsAffected = stmt.executeUpdate();
        int rowsAffectedEstoque = stmtEstoque.executeUpdate();
        
      System.out.println("Atualizando Produto.");
        if (rowsAffected > 0 && rowsAffectedEstoque > 0) {
            System.out.println("Produto atualizado com sucesso.");
            System.out.println(prod.toString());
        } else {
            System.err.println("Nenhum produto encontrado com o ID especificado.");
        }

    } catch (SQLException e) {
        System.err.println("Não foi possível atualizar o produto no Banco de Dados - " + e.getMessage());
    }
}

 public void atualizarQuantEstoque(long idProduto, int novaQuant) throws SQLException {
    String sql = "UPDATE estoque SET quantidade = ? WHERE id_produto = ?";  
    
    try (Connection con = getCon(); 
         PreparedStatement stmt = con.prepareStatement(sql)) {
        
        stmt.setInt(1, novaQuant);  
        stmt.setLong(2, idProduto);  
        
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 0) {
            throw new SQLException("Nenhuma linha foi afetada pela atualização da quantidade.");
        }
    } catch(SQLException e){
        System.err.println("Erro ao atualizar a quantidade do produto com ID " + idProduto);
        e.printStackTrace();  
        throw e;  
    }
}


  
   
    public Produto obterProduto(long id) throws SQLException {
    String sql = "SELECT * FROM Produto WHERE id = ?";
    Connection conn = getCon();
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Produto(
                    rs.getInt("id"),
                    rs.getString("nome_produto"),
                    rs.getDouble("valor_produto")
                );
            }
        }
    }
    return null;
}

public void deletarProduto(long idProduto) throws SQLException {
    String sqlEstoque = "DELETE FROM estoque WHERE id_produto = ?";  
    String sqlProduto = "DELETE FROM produto WHERE id = ?";  

    try (Connection con = getCon()) {
        
        try (PreparedStatement stmtEstoque = con.prepareStatement(sqlEstoque)) {
            stmtEstoque.setLong(1, idProduto);
            stmtEstoque.executeUpdate();
        }

        try (PreparedStatement stmtProduto = con.prepareStatement(sqlProduto)) {
            stmtProduto.setLong(1, idProduto);
            stmtProduto.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;  
    }
}


 
   public  List<Produto> listarTodos() throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    String sql = "SELECT * FROM Produto";

    try (Connection conn = getCon();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            Produto produto = new Produto(
                rs.getInt("id"),
                rs.getString("nome_produto"),
                rs.getDouble("valor_produto")
            );
            produtos.add(produto);
        }

    } catch (SQLException e) {
        System.err.println("Não foi possível listar os produtos do Banco de Dados - " + e.getMessage());
    }

    return produtos;
}

   
}
