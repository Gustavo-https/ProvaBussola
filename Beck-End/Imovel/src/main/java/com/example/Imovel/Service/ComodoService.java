package com.example.Imovel.Service;

import com.example.Imovel.Model.ComodoModel;
import com.example.Imovel.Repository.ComodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComodoService {

    @Autowired
    private ComodoRepository comodoRepository;

    public List<ComodoModel> lista(){
        return comodoRepository.findAll();
    }

    public ComodoModel salvar(ComodoModel comodo){
        return comodoRepository.save(comodo);
    }

    public ComodoModel atualizar(Long id, ComodoModel comodo){
        comodo.setId(id);
        return comodoRepository.save(comodo);
    }

    public void deletar(Long id){
        comodoRepository.deleteById(id);
    }
}
