package com.example.Imovel.Service;

import com.example.Imovel.Model.ComodoModel;
import com.example.Imovel.Model.ImovelModel;
import com.example.Imovel.Repository.ComodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComodoService {

    @Autowired
    private ComodoRepository comodoRepository;

    @Autowired
    private ImovelService imovelService;

    public List<ComodoModel> lista(){
        return comodoRepository.findAll();
    }

    public ComodoModel salvar(ComodoModel comodo){
        ImovelModel imovel = imovelService.getImovelbyId(comodo.getImovel().getId());
        if(imovel != null){
            comodo.setImovel(imovel);
            return comodoRepository.save(comodo);
        }
        return null;
    }

    public ComodoModel atualizar(Long id, ComodoModel comodo){
        comodo.setId(id);
        ImovelModel imovel = imovelService.getImovelbyId(comodo.getImovel().getId());
        if(imovel != null){
            comodo.setImovel(imovel);
            return comodoRepository.save(comodo);
        }
        return null;
    }

    public void deletar(Long id){
        comodoRepository.deleteById(id);
    }
}
