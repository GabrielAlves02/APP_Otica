/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica.modelo.pesqDados;

import com.mycompany.app_otica.modelo.conexao.Conexao;
import com.mycompany.app_otica.modelo.conexao.ConexaoMySQL;
import com.mycompany.app_otica.modelo.dominio.Perfil;
import com.mycompany.app_otica.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author gabri
 */
public class UsuarioDao {
    
    
    private final Conexao conexao;
    
    public UsuarioDao() {
        this.conexao = new ConexaoMySQL();
    }
    
    public String salvar(Usuario usuario) {
        return usuario.getId() == 0L ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {
        String sql = "Insert into USERS(nome, usuario, senha, perfil, ativo) values(?, ?, ?, ?, ?)";
        
        Usuario usuarioTemp = buscarUsuarioPeloUsuario(usuario.getUsuario());

        if(usuarioTemp != null){
            return String.format("Error: usuario %s já existe no banco de dados", usuario.getUsuario());
        }
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado  == 1 ? "Usuario adicionado com sucesso" : "Não foi possível adicionar o Usuuário";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {
        String sql = "Update USERS set nome = ?, usuario = ?, senha = ?, perfil = ?, ativo = ? where Id = ?";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado  == 1 ? "Usuario editado com sucesso" : "Não foi possível editar o Usuuário";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String senhaCrypt = passwordEncoder.encode(usuario.getSenha());
        
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, senhaCrypt);
        preparedStatement.setString(4, usuario.getPerfil().name());
        preparedStatement.setBoolean(5, usuario.isAtivo);
        
        if(usuario.getId() != 0L) {
            preparedStatement.setLong(6, usuario.getId());
        }
    }
    
    public List<Usuario> buscarTodosUsuarios() {
        String sql  = "Select * from USERS";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                usuarios.add(getUsuario(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error : ", e.getMessage()));
        }
        
        return usuarios;
    }
    
    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario();
        
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(Perfil.valueOf(result.getString("perfil")));
        usuario.setAtivo(result.getBoolean("ativo"));
        usuario.setDataHoraCriacao(result.getObject("data_hora_criacao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo_login", LocalDateTime.class));
        
        return usuario;
    }
    
    public Usuario buscarUsuarioPeloId(Long id) {
        String sql  = String.format("Select * from USERS where id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error : ", e.getMessage()));
        }
        
        return null;
    }
    
    
    public Usuario buscarUsuarioPeloUsuario(String usuario) {
        String sql  = String.format("SELECT * FROM users WHERE usuario = '%s'", usuario);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getUsuario(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(String.format("Error : ", e.getMessage()));
        }
        
        return null;
    }
}
