package com.example.Imovel.Repository;

import com.example.Imovel.Model.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<ImovelModel, Long> {
}
