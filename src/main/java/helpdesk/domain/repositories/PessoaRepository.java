package helpdesk.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk.domain.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
