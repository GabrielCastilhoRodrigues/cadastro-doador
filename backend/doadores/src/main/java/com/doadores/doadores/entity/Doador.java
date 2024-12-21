package com.doadores.doadores.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do Doador.
     */
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    /**
     * RG do Doador.
     */
    @JsonProperty("rg")
    private String rg;

    /**
     * Data de Nascimento do Doador.
     */
    @JsonProperty("data_nasc")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data_nasc;

    /**
     * Sexo do Doador.
     */
    @JsonProperty("sexo")
    private String sexo;

    /**
     * Nome da mãe do Doador.
     */
    @JsonProperty("mae")
    private String mae;

    /**
     * Nome do pai do Doador.
     */
    @JsonProperty("pai")
    private String pai;

    /**
     * Email do Doador.
     */
    @JsonProperty("email")
    private String email;

    /**
     * CEP do Endereço do Doador.
     */
    @JsonProperty("cep")
    private String cep;

    /**
     * Endereço do Doador.
     */
    @JsonProperty("endereco")
    private String endereco;

    /**
     * Número do endereço do Doador.
     */
    @JsonProperty("numero")
    private int numero;

    /**
     * Bairro do endereço do Doador.
     */
    @JsonProperty("bairro")
    private String bairro;

    /**
     * Cidade do endereço do Doador.
     */
    @JsonProperty("cidade")
    private String cidade;

    /**
     * Estado do endereço do Doador.
     */
    @JsonProperty("estado")
    private String estado;

    /**
     * Número do telefone fixo do Doador.
     */
    @JsonProperty("telefone_fixo")
    private String telefone_fixo;

    /**
     * Número do celular do Doador.
     */
    @JsonProperty("celular")
    private String celular;

    /**
     * Altura do Doador.
     */
    @JsonProperty("altura")
    private Double altura;

    /**
     * Peso do Doador.
     */
    @JsonProperty("peso")
    private Double peso;

    /**
     * Tipo Sanguíneo do Doador.
     */
    @Enumerated(EnumType.STRING)
    @JsonProperty("tipo_sanguineo")
    private TipoSanguineo tipo_sanguineo;

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public TipoSanguineo getTipo_Sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_Sanguineo(TipoSanguineo tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }
}
