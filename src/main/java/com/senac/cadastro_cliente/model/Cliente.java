package com.senac.cadastro_cliente.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cadastro_clientes")
public class Cliente {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 12)
    private String telefone;

    @Column(name = "contato_adicional", nullable = false, length = 100)
    private String contatoAdicional;

    @Column(name = "credito_aprovado", nullable = false)
    private double limiteCredito;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContatoAdicional() {
        return contatoAdicional;
    }

    public void setContatoAdicional(String contatoAdicional) {
        this.contatoAdicional = contatoAdicional;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Cliente() {
    }

    public Cliente(Integer id, String name, LocalDate dataNascimento, String email, String telefone,
            String contatoAdicional, double limiteCredito) {
        this.id = id;
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.contatoAdicional = contatoAdicional;
        this.limiteCredito = limiteCredito;
    }
}
