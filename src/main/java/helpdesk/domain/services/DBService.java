package helpdesk.domain.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import helpdesk.domain.entities.Chamado;
import helpdesk.domain.entities.Cliente;
import helpdesk.domain.entities.Tecnico;
import helpdesk.domain.enums.Perfil;
import helpdesk.domain.enums.Prioridade;
import helpdesk.domain.enums.Status;
import helpdesk.domain.repositories.ChamadoRepository;
import helpdesk.domain.repositories.ClienteRepository;
import helpdesk.domain.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnioRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Fulano de Tal", "55133100078", "fulano@email.com", "123");
		tec1.addPerfis(Perfil.TECNICO);
		Tecnico tec2 = new Tecnico(null, "Ciclano de Tal", "94967105068", "ciclano@email.com", "456");
		tec2.addPerfis(Perfil.TECNICO);

		Tecnico tec3 = new Tecnico(null, "Beltrano de Tal", "41896497080", "beltrano@email.com", "789");
		tec3.addPerfis(Perfil.TECNICO);

		Tecnico tec4 = new Tecnico(null, "Sicrano de Tal", "73631881061", "sicrano@email.com", "abc");
		tec4.addPerfis(Perfil.TECNICO);

		Tecnico tec5 = new Tecnico(null, "Fulaninho de Tal", "19074375090", "fulaninho@email.com", "def");
		tec5.addPerfis(Perfil.TECNICO);

		Tecnico tec6 = new Tecnico(null, "Ciclaninho de Tal", "86174778061", "ciclaninho@email.com", "ghi");
		tec6.addPerfis(Perfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Linus torvals", "79264144099", "torvals@email.com", "123");
		cli1.addPerfis(Perfil.CLIENTE);

		Cliente cli2 = new Cliente(null, "Steve Jobs", "54139849010", "stevejobs@email.com", "456");
		cli2.addPerfis(Perfil.CLIENTE);

		Cliente cli3 = new Cliente(null, "Bill Gates", "28245746070", "billgates@email.com", "789");
		cli3.addPerfis(Perfil.CLIENTE);

		Cliente cli4 = new Cliente(null, "Mark Zuckerberg", "26149298086", "markzuckerberg@email.com", "abc");
		cli4.addPerfis(Perfil.CLIENTE);

		Cliente cli5 = new Cliente(null, "Elon Musk", "71347461000", "elonmusk@email.com", "def");
		cli5.addPerfis(Perfil.CLIENTE);

		Cliente cli6 = new Cliente(null, "Tim Cook", "07605775016", "timcook@email.com", "ghi");
		cli6.addPerfis(Perfil.CLIENTE);

		Chamado c1 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Concertar cabo de rede",
				"Cabo de rede danificado por conta do sol e da chuva.", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Problema no servidor",
				"Servidor não está respondendo.", tec2, cli2);

		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Troca de toner", "Impressora com toner vazio.",
				tec3, cli3);

		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Atualização de sistema operacional",
				"Sistema operacional desatualizado.", tec4, cli4);

		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Problema com conexão Wi-Fi",
				"Wi-Fi caindo constantemente.", tec5, cli5);

		tecnioRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));

	}
}
