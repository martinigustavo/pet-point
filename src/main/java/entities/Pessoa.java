/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "pessoa")
/**
 *
 * @author evely
 */
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sexo;
    private String cpf;
    private String telefone;
    private String email;
    private Date   data_nascimento;
    private Date   data_cadastro;
    private Integer status;
    @OneToOne  
    @JoinColumn(name = "endereco_id")
    private Integer endereco_id;
    @OneToOne
    @JoinColumn(name = "grupo_usuario")
    private Integer grupo_usuario_id;
    
    public Pessoa(Integer id, String nome, String sexo, String cpf, String telefone, String email, Date data_nascimento, Date data_cadastro, Integer status, Integer endereco_id, Integer grupo_usuario_id) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.data_cadastro = data_cadastro;
        this.status = status;
        this.endereco_id = endereco_id;
        this.grupo_usuario_id = grupo_usuario_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEndereco() {
        return endereco_id;
    }

    public void setEndereco (Integer endereco_id) {
        this.endereco_id = endereco_id;
    }

    public Integer getGrupo_usuario() {
        return grupo_usuario_id;
    }

    public void setGrupo_usuario(Integer grupo_usuario_id) {
        this.grupo_usuario_id = grupo_usuario_id;
    }
      
}
