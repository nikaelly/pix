package matera.bootcamp.pix.usuario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Chave;
import matera.bootcamp.pix.service.usuario.ConsultaChaveUsuarioService;

@RestController
@RequiredArgsConstructor
public class UsuarioConsultaChavesController {


    private final ConsultaChaveUsuarioService consultaChaveUsuarioService;

    @GetMapping("/api/v1/usuario/{id}/chaves")
    public ResponseEntity<List<Chave>> consultaChave(@PathVariable Long id) {
        List<Chave> chavesDoUsuario = consultaChaveUsuarioService
                .consultarPorIdDeUsuario(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chavesDoUsuario);
    }
}
