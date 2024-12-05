package br.ecommerce.projetoEcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Categoria {
    @Id
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "tipo_categoria", length = 50)
    private String tipoCategoria;

    @OneToMany(mappedBy = "idCategoria")//mapeia o objeto do Java
    @JsonIgnoreProperties("idCategoria")
    private List<Produto> produtos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
