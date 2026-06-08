package com.senac.cadastro_cliente.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "conta_bancaria")
public class contaBancaria {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_conta", nullable = false, length = 7)
    private String numeroConta;

    @Column(name = "digito_conta", nullable = false)
    private int digitoConta;

    @Column(name = "numero_agencia", nullable = false, length = 5)
    private String numeroAgencia;

    @Column(name = "digito_agencia", nullable = false)
    private int digitoAgencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "banco", nullable = false)
    private TipoBanco banco;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "id_cliente", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    // Construtor padrão
    public contaBancaria() {
    }

    // Construtor completo
    public contaBancaria(Integer id, String numeroConta, int digitoConta, String numeroAgencia, int digitoAgencia,
            TipoBanco banco, Cliente cliente) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.digitoConta = digitoConta;
        this.numeroAgencia = numeroAgencia;
        this.digitoAgencia = digitoAgencia;
        this.banco = banco;
        this.cliente = cliente;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(int digitoConta) {
        this.digitoConta = digitoConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(int digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public TipoBanco getBanco() {
        return banco;
    }

    public void setBanco(TipoBanco banco) {
        this.banco = banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
