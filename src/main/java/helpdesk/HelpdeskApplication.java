package helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import helpdesk.domain.entities.Chamado;
import helpdesk.domain.entities.Cliente;
import helpdesk.domain.entities.Tecnico;
import helpdesk.domain.enums.Perfil;
import helpdesk.domain.enums.Prioridade;
import helpdesk.domain.enums.Status;
import helpdesk.domain.repositories.ChamadoRepository;
import helpdesk.domain.repositories.ClienteRepository;
import helpdesk.domain.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	
	@Autowired
	private TecnicoRepository tecnioRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Fulano de Tal", "69108976090", "fulano@email.com", "123"); 
		tec1.addPerfis(Perfil.TECNICO);
		
		Cliente cli1 = new Cliente(null, "Linus torvals", "41236016009", "torvals@email.com", "123");
		cli1.addPerfis(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Concertar cabo de rede", "Cabo de rede danificado por conta do sol e da chuva.", tec1, cli1);
		
		tecnioRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
