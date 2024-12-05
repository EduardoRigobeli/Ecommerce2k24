package br.ecommerce.projetoEcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Produto {
    @Id
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nm_produto")
    private String nomeProduto;

    @Column
    private float preco;

    @Column
    private Integer estoque;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria idCategoria;

    @OneToMany(mappedBy = "idProduto")
    @JsonIgnoreProperties("idProduto")
    private List<AuditPrecoProduto> auditPreco;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<AuditPrecoProduto> getAuditPreco() {
        return auditPreco;
    }

    public void setAuditPreco(List<AuditPrecoProduto> auditPreco) {
        this.auditPreco = auditPreco;
    }
}

