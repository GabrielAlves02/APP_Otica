/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica;

import com.mycompany.app_otica.modelo.conexao.ConexaoMySQL;
import com.mycompany.app_otica.modelo.dominio.Perfil;
import com.mycompany.app_otica.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author gabri
 */
public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        String sql = "Select * from USERS";
        
        ConexaoMySQL conexao = new ConexaoMySQL();

        Usuario USERS = new Usuario(null, "Gabriel Java2", "123gabriel", "Gabriel Java2", Perfil.Padrao, LocalDateTime.now(), LocalDateTime.now());
        
        String inserirSQL = "Insert into USERS(nome, senha, usuario) values(?, ?, ?)";
        
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        
        preparedStatement.setString(1, USERS.getNome());
        preparedStatement.setString(2, USERS.getSenha());
        preparedStatement.setString(3, USERS.getUsuario());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        
        System.out.println(resultadoDoCadastro);
        
        //System.out.println(conexaoMySQL.obterConexao());
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()) {
            
            System.out.println(result.getString("nome"));
        }
    }
    
    
}
