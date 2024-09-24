/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica.controller;

import com.mycompany.app_otica.modelo.dominio.Usuario;
import com.mycompany.app_otica.modelo.pesqDados.AutenticacaoDao;
import com.mycompany.app_otica.view.formulario.Login;
import com.mycompany.app_otica.view.modelo.LoginDto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class LoginController implements ActionListener{
    
    private final Login login;
    private AutenticacaoDao autenticacaoDao;

    public LoginController(Login login) {
        this.login = login;
        this.autenticacaoDao = new AutenticacaoDao();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String acao  = ae.getActionCommand().toLowerCase();
        
        switch(acao) {
            case "login": login(); break;
            case "cancelar": cancelar(); break;
        }
    }

    private void login() {
        String usuario = this.login.getTxtLoginUsuario().getText();
        String senha = this.login.getTxtLoginSenha().getText();
        
        if(usuario.equals("") || senha.equals("")) {
            this.login.getLabelErrorMensagem().setText("Usuário ou senha devem ser preenchidos!");
            return;
        }
        
        LoginDto loginDto = new LoginDto(usuario, senha);
         
        Usuario usuarioTemp = this.autenticacaoDao.login(loginDto);
         
        if(usuarioTemp != null) {
            JOptionPane.showConfirmDialog(null, usuarioTemp.getNome());
        } else {
            this.login.getLabelErrorMensagem().setText("Usuário ou senha incorreto!");
        }
    }

    private void cancelar() {
        
    }
    
    
}
