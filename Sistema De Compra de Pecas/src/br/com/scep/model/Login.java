package br.com.scep.model;

import static br.com.svp.util.ConexaoBd.getCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jeffe_cjks0ez
 */
public class Login {
    private String cpf;
    private String senha;
    
    public Login(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login{" + "cpf=" + cpf + ", senha=" + senha + '}';
    }
    


        
    }

