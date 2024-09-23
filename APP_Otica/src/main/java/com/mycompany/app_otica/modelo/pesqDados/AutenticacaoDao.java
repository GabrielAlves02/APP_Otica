/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica.modelo.pesqDados;

import com.mycompany.app_otica.modelo.dominio.Perfil;
import com.mycompany.app_otica.modelo.dominio.Usuario;
import com.mycompany.app_otica.view.modelo.LoginDto;
import com.mycompany.app_otica.view.modelo.exception.NegocioException;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author gabri
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    public boolean temPermissao(Usuario usuario) {
        try {
            permisao(usuario);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissão", 0);
            return false;
        }
    }
    
    private void permisao(Usuario usuario) {
        if(!Perfil.admim.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem Permissao para realizar essa ação");
        }
    }
    
    public Usuario login(LoginDto login) {
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());
        
        if(usuario == null || !usuario.isAtivo())
            return null;
        
        if(usuario.isAtivo() && validarSenha(usuario.getSenha(), login.getSenha())) {
            return usuario;
        }
        
        return null;
    }

    private boolean validarSenha(String senhaUsuario, String senhaLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(senhaLogin, senhaUsuario);
    }
    
}
