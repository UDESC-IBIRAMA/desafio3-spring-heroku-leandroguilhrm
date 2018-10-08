/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.projetospring.resource;

import br.udesc.ceavi.dsw.projetospring.model.Veiculo;
import br.udesc.ceavi.dsw.projetospring.repositorio.VeiculoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculosResource {
    @Autowired
    private VeiculoRepositorio veiculos;
    
    @GetMapping("/{id}")
    public Veiculo buscar(@PathVariable Long id){
        return veiculos.findOne(id);
    }
    
    @GetMapping
    public List<Veiculo> pesquisar(){
        return veiculos.findAll();
    }
    
    @PostMapping("/novo")
    public Veiculo salvar(@RequestBody Veiculo veiculo){
        return veiculos.save(veiculo);
    }
    
    @PutMapping(value = "/altera/{id}")
    public Veiculo altera(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo v = veiculos.findOne(id);

        if (v.isPresent()) {
            Veiculo v1 = v.get();
            v1.setId(veiculo.getId());
            v1.setMontadora(veiculo.getMontadora());
            v1.setModelo(veiculo.getModelo());
            v1.setCor(veiculo.getCor());
            v1.setKm(veiculo.getKm());
            v1.setMotor(veiculo.getMotor());

            return veiculos.save(v1);
        }
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        veiculos.delete(id);
    }
}
