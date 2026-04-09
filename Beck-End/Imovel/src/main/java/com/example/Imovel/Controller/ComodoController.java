package com.example.Imovel.Controller;

import com.example.Imovel.Model.ComodoModel;
import com.example.Imovel.Service.ComodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comodo")
@CrossOrigin(origins = "*")
public class ComodoController {

    @Autowired
    private ComodoService comodoService;

    @GetMapping
    public List<ComodoModel> listar(){
        return comodoService.lista();
    }

    @PostMapping
    public ComodoModel salvar(@RequestBody ComodoModel comodo){
        return comodoService.salvar(comodo);
    }

    @PutMapping("/{id}")
    public ComodoModel atualizar(@PathVariable Long id, @RequestBody ComodoModel comodo){
        comodo.setId(id);
        return comodoService.salvar(comodo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        comodoService.deletar(id);
    }
}
