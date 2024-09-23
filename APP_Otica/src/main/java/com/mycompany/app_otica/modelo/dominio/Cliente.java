/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_otica.modelo.dominio;

import java.time.LocalDateTime;

/**
 *
 * @author gabri
 */
public class Cliente {
    private Long id;
    private Cliente usuario;
    private String cred;
    private String endereco;
    private String bairro;
    private String cidade;
    private String telefone;
    private String perto_d_esf;
    private String perto_e_esf;
    private String perto_d_cil;
    private String perto_e_cil;
    private String perto_d_eixo;
    private String perto_e_eixo;
    private String perto_d_dnp;
    private String perto_e_dnp;
    private String perto_d_alt;
    private String perto_e_alt;
    private String longe_d_esf;
    private String longe_e_esf;
    private String longe_d_cil;
    private String longe_e_cil;
    private String longe_d_eixo;
    private String longe_e_eixo;
    private String longe_d_dnp;
    private String longe_e_dnp;
    private String longe_d_alt;
    private String longe_e_alt;
    private String observacao;
    private String  tipo_armacao;
    private LocalDateTime data_hora_criacao;
    private Usuario criador;

    public Cliente() {
    }

    public Cliente(Long id, Cliente usuario, String cred, String endereco, String bairro, String cidade, String telefone, String perto_d_esf, String perto_e_esf, String perto_d_cil, String perto_e_cil, String perto_d_eixo, String perto_e_eixo, String perto_d_dnp, String perto_e_dnp, String perto_d_alt, String perto_e_alt, String longe_d_esf, String longe_e_esf, String longe_d_cil, String longe_e_cil, String longe_d_eixo, String longe_e_eixo, String longe_d_dnp, String longe_e_dnp, String longe_d_alt, String longe_e_alt, String observacao, String tipo_armacao, LocalDateTime data_hora_criacao, Usuario criador) {
        this.id = id;
        this.usuario = usuario;
        this.cred = cred;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.perto_d_esf = perto_d_esf;
        this.perto_e_esf = perto_e_esf;
        this.perto_d_cil = perto_d_cil;
        this.perto_e_cil = perto_e_cil;
        this.perto_d_eixo = perto_d_eixo;
        this.perto_e_eixo = perto_e_eixo;
        this.perto_d_dnp = perto_d_dnp;
        this.perto_e_dnp = perto_e_dnp;
        this.perto_d_alt = perto_d_alt;
        this.perto_e_alt = perto_e_alt;
        this.longe_d_esf = longe_d_esf;
        this.longe_e_esf = longe_e_esf;
        this.longe_d_cil = longe_d_cil;
        this.longe_e_cil = longe_e_cil;
        this.longe_d_eixo = longe_d_eixo;
        this.longe_e_eixo = longe_e_eixo;
        this.longe_d_dnp = longe_d_dnp;
        this.longe_e_dnp = longe_e_dnp;
        this.longe_d_alt = longe_d_alt;
        this.longe_e_alt = longe_e_alt;
        this.observacao = observacao;
        this.tipo_armacao = tipo_armacao;
        this.data_hora_criacao = data_hora_criacao;
        this.criador = criador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    public String getCred() {
        return cred;
    }

    public void setCred(String cred) {
        this.cred = cred;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPerto_d_esf() {
        return perto_d_esf;
    }

    public void setPerto_d_esf(String perto_d_esf) {
        this.perto_d_esf = perto_d_esf;
    }

    public String getPerto_e_esf() {
        return perto_e_esf;
    }

    public void setPerto_e_esf(String perto_e_esf) {
        this.perto_e_esf = perto_e_esf;
    }

    public String getPerto_d_cil() {
        return perto_d_cil;
    }

    public void setPerto_d_cil(String perto_d_cil) {
        this.perto_d_cil = perto_d_cil;
    }

    public String getPerto_e_cil() {
        return perto_e_cil;
    }

    public void setPerto_e_cil(String perto_e_cil) {
        this.perto_e_cil = perto_e_cil;
    }

    public String getPerto_d_eixo() {
        return perto_d_eixo;
    }

    public void setPerto_d_eixo(String perto_d_eixo) {
        this.perto_d_eixo = perto_d_eixo;
    }

    public String getPerto_e_eixo() {
        return perto_e_eixo;
    }

    public void setPerto_e_eixo(String perto_e_eixo) {
        this.perto_e_eixo = perto_e_eixo;
    }

    public String getPerto_d_dnp() {
        return perto_d_dnp;
    }

    public void setPerto_d_dnp(String perto_d_dnp) {
        this.perto_d_dnp = perto_d_dnp;
    }

    public String getPerto_e_dnp() {
        return perto_e_dnp;
    }

    public void setPerto_e_dnp(String perto_e_dnp) {
        this.perto_e_dnp = perto_e_dnp;
    }

    public String getPerto_d_alt() {
        return perto_d_alt;
    }

    public void setPerto_d_alt(String perto_d_alt) {
        this.perto_d_alt = perto_d_alt;
    }

    public String getPerto_e_alt() {
        return perto_e_alt;
    }

    public void setPerto_e_alt(String perto_e_alt) {
        this.perto_e_alt = perto_e_alt;
    }

    public String getLonge_d_esf() {
        return longe_d_esf;
    }

    public void setLonge_d_esf(String longe_d_esf) {
        this.longe_d_esf = longe_d_esf;
    }

    public String getLonge_e_esf() {
        return longe_e_esf;
    }

    public void setLonge_e_esf(String longe_e_esf) {
        this.longe_e_esf = longe_e_esf;
    }

    public String getLonge_d_cil() {
        return longe_d_cil;
    }

    public void setLonge_d_cil(String longe_d_cil) {
        this.longe_d_cil = longe_d_cil;
    }

    public String getLonge_e_cil() {
        return longe_e_cil;
    }

    public void setLonge_e_cil(String longe_e_cil) {
        this.longe_e_cil = longe_e_cil;
    }

    public String getLonge_d_eixo() {
        return longe_d_eixo;
    }

    public void setLonge_d_eixo(String longe_d_eixo) {
        this.longe_d_eixo = longe_d_eixo;
    }

    public String getLonge_e_eixo() {
        return longe_e_eixo;
    }

    public void setLonge_e_eixo(String longe_e_eixo) {
        this.longe_e_eixo = longe_e_eixo;
    }

    public String getLonge_d_dnp() {
        return longe_d_dnp;
    }

    public void setLonge_d_dnp(String longe_d_dnp) {
        this.longe_d_dnp = longe_d_dnp;
    }

    public String getLonge_e_dnp() {
        return longe_e_dnp;
    }

    public void setLonge_e_dnp(String longe_e_dnp) {
        this.longe_e_dnp = longe_e_dnp;
    }

    public String getLonge_d_alt() {
        return longe_d_alt;
    }

    public void setLonge_d_alt(String longe_d_alt) {
        this.longe_d_alt = longe_d_alt;
    }

    public String getLonge_e_alt() {
        return longe_e_alt;
    }

    public void setLonge_e_alt(String longe_e_alt) {
        this.longe_e_alt = longe_e_alt;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo_armacao() {
        return tipo_armacao;
    }

    public void setTipo_armacao(String tipo_armacao) {
        this.tipo_armacao = tipo_armacao;
    }

    public LocalDateTime getData_hora_criacao() {
        return data_hora_criacao;
    }

    public void setData_hora_criacao(LocalDateTime data_hora_criacao) {
        this.data_hora_criacao = data_hora_criacao;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
    
    
    

}
