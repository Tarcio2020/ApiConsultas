package com.github.Tarcio2020.ApiConsultasMedicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Tarcio2020.ApiConsultasMedicas.entities.ConsultasMedicasEntity;
import com.github.Tarcio2020.ApiConsultasMedicas.service.ConsultasMedicasService;

@RestController
@RequestMapping("/consulta")
public class ConsultasMedicasController {

	@Autowired
	private ConsultasMedicasService consultasMedicasService;
	
	@PostMapping
	public ResponseEntity<ConsultasMedicasEntity> criar(@RequestBody ConsultasMedicasEntity consultasMedicasEntity) {
		ConsultasMedicasEntity criarConsulta = consultasMedicasService.criar(consultasMedicasEntity);
		return ResponseEntity.status(HttpStatus.OK).body(criarConsulta);
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultasMedicasEntity>> lista() {
	    List<ConsultasMedicasEntity> consultasMedicas = consultasMedicasService.lista();
	    return ResponseEntity.ok(consultasMedicas);
	}
	
	@DeleteMapping(value = "/{id_consulta}")
	public ResponseEntity<Void> deletar(@PathVariable Long id_consulta) {
		consultasMedicasService.deletar(id_consulta);
		return ResponseEntity.noContent().build();
	} 
 
    @PutMapping(value = "/{id_consulta}")
    public ResponseEntity<ConsultasMedicasEntity> update(@PathVariable Long id_consulta, @RequestBody ConsultasMedicasEntity consultasMedicasEntity) {
        ConsultasMedicasEntity updateConsulta = consultasMedicasService.update(id_consulta, consultasMedicasEntity);
        return ResponseEntity.ok(updateConsulta);
    }

    
    @PatchMapping(value = "/{id_consulta}")
    public ResponseEntity<ConsultasMedicasEntity> patch(@PathVariable Long id_consulta, @RequestBody ConsultasMedicasEntity updates) {
    	ConsultasMedicasEntity updateConsultasMedicas = consultasMedicasService.atualizarParcialmente(id_consulta, updates);
    	if (updateConsultasMedicas != null) {
    		return ResponseEntity.ok(updateConsultasMedicas);
    	} else {
    		return ResponseEntity.notFound().build();  
    	}
    }
    
}
	

