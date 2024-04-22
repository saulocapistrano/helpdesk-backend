package helpdesk.domain.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import helpdesk.domain.dtos.TecnicoDTO;
import helpdesk.domain.entities.Tecnico;
import helpdesk.domain.services.TecnicoService;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoController {
	
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}


	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		List<Tecnico> listTecnico = service.findAll();
		List<TecnicoDTO> listDTO = listTecnico.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	
	}


}
