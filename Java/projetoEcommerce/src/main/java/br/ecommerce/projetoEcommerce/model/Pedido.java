package br.ecommerce.projetoEcommerce.model;

import jakarta.persistence.*;

@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// dizer que essa coluna é um auto_increment
    @Column (name = "id_pedido")
    private Integer idPedido;

    @Column (name = "dt_pedido")
    private String dataPedido;

    @Column
    private float total;

    @Column
    private String status;

    public Integer getIdpedido() {
        return idPedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idPedido = idpedido;
    }

    public String getDatapedido() {
        return dataPedido;
    }

    public void setDatapedido(String datapedido) {
        this.dataPedido = datapedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
