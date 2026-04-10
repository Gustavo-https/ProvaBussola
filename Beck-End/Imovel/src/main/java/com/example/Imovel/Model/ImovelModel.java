package com.example.Imovel.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ImovelModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;

    public String descricao;
    public LocalDate dataCompra;
    public String endereco;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
    private List<ComodoModel> comodos;

    public List<ComodoModel> getComodos() {
        return comodos;
    }

    public void setComodos(List<ComodoModel> comodos) {
        this.comodos = comodos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
