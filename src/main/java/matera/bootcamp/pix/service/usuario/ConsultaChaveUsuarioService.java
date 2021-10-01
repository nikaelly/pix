package matera.bootcamp.pix.service.usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Chave;
import matera.bootcamp.pix.domain.repository.ChaveRepository;

@Service
@RequiredArgsConstructor
public class ConsultaChaveUsuarioService {

    private final ChaveRepository chaveRepository;

    public List<Chave> consultarPorIdDeUsuario(Long id) {
        return chaveRepository.findAllByUsuarioId(id);
    }
}
