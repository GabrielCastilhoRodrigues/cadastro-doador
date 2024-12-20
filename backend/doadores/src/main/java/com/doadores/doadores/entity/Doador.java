package com.doadores.doadores.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Doador.
 */
@Entity
public class Doador {

    /**
     * ID do Doador.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nome do Doador.
     */
    private String nome;

    /**
     * RG do Doador.
     */
    private String rg;

    /**
     * Data de Nascimento do Doador.
     */
    private Date data_nasc;

    /**
     * Sexo do Doador.
     */
    private String sexo;

    /**
     * Nome da mãe do Doador.
     */
    private String mae;

    /**
     * Nome do pai do Doador.
     */
    private String pai;

    /**
     * Email do Doador.
     */
    private String email;

    /**
     * CEP do Endereço do Doador.
     */
    private String cep;

    /**
     * Endereço do Doador.
     */
    private String endereco;

    /**
     * Número do endereço do Doador.
     */
    private int numero;

    /**
     * Bairro do endereço do Doador.
     */
    private String bairro;

    /**
     * Cidade do endereço do Doador.
     */
    private String cidade;

    /**
     * Estado do endereço do Doador.
     */
    private String estado;

    /**
     * Número do telefone fixo do Doador.
     */
    private String telefone_fixo;

    /**
     * Número do celular do Doador.
     */
    private String celular;

    /**
     * Altura do Doador.
     */
    private Double altura;

    /**
     * Peso do Doador.
     */
    private Double peso;

    /**
     * Tipo Sanguíneo do Doador.
     */
    private String tipo_sanguineo;

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nasc() {
        return this.data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return this.mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return this.pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone_fixo() {
        return this.telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Double getAltura() {
        return this.altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTipo_sanguineo() {
        return this.tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }
}
