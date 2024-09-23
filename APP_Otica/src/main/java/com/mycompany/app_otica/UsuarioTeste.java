/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica;

import com.mycompany.app_otica.modelo.dominio.Perfil;
import com.mycompany.app_otica.modelo.dominio.Usuario;
import com.mycompany.app_otica.modelo.pesqDados.UsuarioDao;
import java.time.LocalDateTime;

/**
 *
 * @author gabri
 */
public class UsuarioTeste {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1L, "Gabriel Alves 3", "culysoft", "1234", Perfil.admim, null, null);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.println(mensagem);
    }
    
}
