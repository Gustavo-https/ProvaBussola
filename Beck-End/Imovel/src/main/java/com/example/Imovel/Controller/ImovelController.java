package com.example.Imovel.Controller;

import com.example.Imovel.Model.ImovelModel;
import com.example.Imovel.Service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Imovel")
@CrossOrigin(origins = " http://localhost:4200")
public class ImovelController {

    @Autowired
    private ImovelService imovelService;


    @GetMapping
    public List<ImovelModel> listar(){
        return imovelService.lista();
    }

    @PostMapping
    public ImovelModel salvar(@RequestBody ImovelModel imovel){
        System.out.println("Imóvel recebido: " + imovel.getDescricao());
        System.out.println("Comodos recebidos: " + imovel.getComodos());
        return imovelService.salvar(imovel);
    }

    @PutMapping("/{id}")
    public ImovelModel atualizar(@PathVariable Long id, @RequestBody ImovelModel imovel){
        imovel.setId(id);
        return imovelService.salvar(imovel);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        imovelService.deletar(id);
    }
}
