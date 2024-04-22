package helpdesk.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk.domain.entities.Tecnico;
import helpdesk.domain.repositories.TecnicoRepository;
import helpdesk.domain.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	public List<Tecnico> findAll(){
		return repository.findAll();
	}
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado id: "+id));
	}
	
}
