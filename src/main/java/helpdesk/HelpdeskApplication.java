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
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
