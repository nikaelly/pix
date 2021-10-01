package matera.bootcamp.pix.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import matera.bootcamp.pix.domain.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    Optional<ContaCorrente> findByUsuarioId(Long id);

}
