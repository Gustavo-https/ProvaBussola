package com.example.Imovel.Service;

import com.example.Imovel.Model.ImovelModel;
import com.example.Imovel.Repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<ImovelModel> lista(){
        return imovelRepository.findAll();
    }

    public ImovelModel salvar(ImovelModel imovel){
        return imovelRepository.save(imovel);
    }

    public ImovelModel atualizar(Long id, ImovelModel imovel){
        imovel.setId(id);
        return imovelRepository.save(imovel);
    }

    public void deletar(Long id){
        imovelRepository.deleteById(id);
    }
}
