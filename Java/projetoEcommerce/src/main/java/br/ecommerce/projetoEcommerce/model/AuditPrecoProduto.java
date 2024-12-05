package br.ecommerce.projetoEcommerce.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "audit_preco_produto")
public class AuditPrecoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_audit")
    private Integer idAudit;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private Produto idProduto;

    @Column(name = "dt_modificacao")
    private Date dtModificacao;

    @Column(name = "preco_antigo")
    private Integer precoAntigo;

    @Column(name = "preco_novo")
    private Integer precoNovo;

    @Column
    private String motivo;

    public Integer getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(Integer idAudit) {
        this.idAudit = idAudit;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Date getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(Date dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    public Integer getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(Integer precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public Integer getPrecoNovo() {
        return precoNovo;
    }

    public void setPrecoNovo(Integer precoNovo) {
        this.precoNovo = precoNovo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
