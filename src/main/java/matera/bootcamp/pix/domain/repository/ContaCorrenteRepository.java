package matera.bootcamp.pix.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matera.bootcamp.pix.domain.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

}
