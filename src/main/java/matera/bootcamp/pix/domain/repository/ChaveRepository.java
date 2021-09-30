package matera.bootcamp.pix.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matera.bootcamp.pix.domain.model.Chave;

public interface ChaveRepository extends JpaRepository<Chave, Long> {

}
