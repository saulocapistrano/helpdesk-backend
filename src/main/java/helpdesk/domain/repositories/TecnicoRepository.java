package helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import helpdesk.domain.entities.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
