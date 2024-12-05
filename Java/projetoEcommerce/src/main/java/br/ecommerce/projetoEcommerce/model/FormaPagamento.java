package br.ecommerce.projetoEcommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
    @Id
    @Column (name = "id_forma")
    private Integer idForma;

    @Column (name = "forma_pagamento")
    private String formaPagamento;

    public Integer getIdforma() {
        return idForma;
    }

    public void setIdforma(Integer idforma) {
        this.idForma = idforma;
    }

    public String getFormapagamento() {
        return formaPagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formaPagamento = formapagamento;
    }
}
