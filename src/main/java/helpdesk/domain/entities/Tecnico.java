package helpdesk.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

public class Tecnico extends Pessoa{

	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Long id, @NotNull(message = "Campo nome é obrigatório") String nome,
			@NotNull(message = "Campo cpf é obrigatório") @CPF String cpf,
			@NotNull(message = "Campo email é obrigatorio") @Email String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
}
