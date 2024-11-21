package br.ecommerce.projetoEcommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class FormaPagamento {

    @Id
    @Column(name = "id_forma")
    private Integer idForma;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    public Integer getIdForma() {
        return idForma;
    }

    public void setIdForma(Integer idForma) {
        this.idForma = idForma;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
