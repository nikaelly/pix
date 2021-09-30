package matera.bootcamp.pix.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import matera.bootcamp.pix.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
