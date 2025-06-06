
import br.com.scep.model.Estoque;
import br.com.scep.model.Produto;
import static  br.com.svp.util.ConexaoBd.getCon;
import static  br.com.svp.util.ConexaoBd.verificarConn;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jeffe_cjks0ez
 */
public class Teste  {
    public static void main(String[] args) {
        getCon();
        verificarConn();
        Produto prod = new Produto();
        System.out.println(prod.getId());
        Estoque estoque = new Estoque();
    
        
    }

    public Teste() {
    }
}
