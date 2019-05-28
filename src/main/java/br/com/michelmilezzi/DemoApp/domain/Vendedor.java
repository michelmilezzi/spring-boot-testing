package br.com.michelmilezzi.DemoApp.domain;

import java.math.BigDecimal;

public class Vendedor {

    private String nome;
    private BigDecimal salario;

    public Vendedor(String nome, BigDecimal salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

}
