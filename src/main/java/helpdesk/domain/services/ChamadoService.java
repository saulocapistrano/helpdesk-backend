package helpdesk.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import helpdesk.domain.dtos.ChamadoDTO;
import helpdesk.domain.entities.Chamado;
import helpdesk.domain.entities.Cliente;
import helpdesk.domain.entities.Tecnico;
import helpdesk.domain.enums.Prioridade;
import helpdesk.domain.enums.Status;
import helpdesk.domain.repositories.ChamadoRepository;
import helpdesk.domain.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecService;
	@Autowired
	private ClienteService cliService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecService.findById(obj.getTecnico());
		// System.out.println(obj.getStatus());

		try {
			Cliente cliente = cliService.findById(obj.getCliente());

			Chamado chamado = new Chamado();

			if (obj.getId() != null) {
				chamado.setId(obj.getId());
			}

			if(obj.getStatus().equals(3)) {
				chamado.setDataFechamento(LocalDate.now());
			}
			
			chamado.setTecnico(tecnico);
			chamado.setCliente(cliente);
			chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
			chamado.setStatus(Status.toEnum(obj.getStatus()));
			chamado.setTitulo(obj.getTitulo());
			chamado.setObservacoes(obj.getObservacoes());

			return chamado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Error("ERRRO INESPERADO.");
		}
	}



}
