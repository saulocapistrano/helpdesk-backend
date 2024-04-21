package helpdesk.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import helpdesk.domain.enums.Perfil;

@Entity(name = "tb_tecnico")
public class Tecnico extends Pessoa{
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "tecnico" )
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfis(Perfil.TECNICO);
	}

	public Tecnico(Long id, @NotNull(message = "Campo nome é obrigatório") String nome,
			@NotNull(message = "Campo cpf é obrigatório") @CPF String cpf,
			@NotNull(message = "Campo email é obrigatorio") @Email String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfis(Perfil.TECNICO);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
}
