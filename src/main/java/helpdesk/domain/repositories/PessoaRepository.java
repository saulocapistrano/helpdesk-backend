package helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk.domain.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
