/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.dsw.projetospring.repositorio;

import br.udesc.ceavi.dsw.projetospring.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 07610115959
 */
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {

    //public void delete(Long id);
    
    //public Veiculo findOne(Long id);
}
