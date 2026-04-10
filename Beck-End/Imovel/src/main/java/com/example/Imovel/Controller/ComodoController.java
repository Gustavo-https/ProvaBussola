package com.example.Imovel.Controller;

import com.example.Imovel.Model.ComodoModel;
import com.example.Imovel.Service.ComodoService;
import com.example.Imovel.Service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comodo")
@CrossOrigin(origins = " http://localhost:4200")
public class ComodoController {

    @Autowired
    private ComodoService comodoService;

    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public List<ComodoModel> listar(){
        return comodoService.lista();
    }

    @PostMapping
    public ComodoModel salvar(@RequestBody ComodoModel comodo){
        var imovel = imovelService.getImovelbyId(comodo.getImovel().getId());
        if(imovel != null){
            comodo.setImovel(imovel);
            return comodoService.salvar(comodo);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ComodoModel atualizar(@PathVariable Long id, @RequestBody ComodoModel comodo){
        comodo.setId(id);
        var imovel = imovelService.getImovelbyId(comodo.getImovel().getId());
        if(imovel != null){
            comodo.setImovel(imovel);
            return comodoService.salvar(comodo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        comodoService.deletar(id);
    }
}

