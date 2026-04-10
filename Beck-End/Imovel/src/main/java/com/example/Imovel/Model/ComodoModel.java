package com.example.Imovel.Model;

import jakarta.persistence.*;

@Entity
public class ComodoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelModel imovel;

    public ImovelModel getImovel() {
        return imovel;
    }

    public void setImovel(ImovelModel imovel) {
        this.imovel = imovel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
