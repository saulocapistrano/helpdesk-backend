package helpdesk.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import helpdesk.domain.dtos.ChamadoDTO;
import helpdesk.domain.entities.Chamado;
import helpdesk.domain.services.ChamadoService;

@Controller
@RequestMapping(value = "/chamados")
public class ChamadoController {

	// primeiro deve ser injetado a camada de serviço
	@Autowired
	private ChamadoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id ){
	Chamado obj = service.findById(id);
	return ResponseEntity.ok().body(new ChamadoDTO(obj));	
	}
}
