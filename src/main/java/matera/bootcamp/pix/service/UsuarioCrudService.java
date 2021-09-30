package matera.bootcamp.pix.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Usuario;
import matera.bootcamp.pix.domain.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioCrudService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> buscaPaginado(Pageable pageable) {

        return usuarioRepository.findAll(pageable);
    }
}
