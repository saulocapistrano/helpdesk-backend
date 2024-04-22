package helpdesk.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import helpdesk.domain.enums.Perfil;

@Entity
public class Cliente extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfis(Perfil.CLIENTE);
	}

	public Cliente(Integer id, @NotNull(message = "Campo nome é obrigatório") String nome,
			@NotNull(message = "Campo cpf é obrigatório") @CPF String cpf,
			@NotNull(message = "Campo email é obrigatorio") @Email String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfis(Perfil.CLIENTE);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
}
