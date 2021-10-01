package matera.bootcamp.pix.usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Usuario;
import matera.bootcamp.pix.service.usuario.UsuarioCrudService;

@RestController
@RequiredArgsConstructor
public class UsuarioCrudApiController {

    private final UsuarioCrudService usuarioCrudService;

    @PostMapping("/api/v1/usuario")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario,
                            HttpServletRequest httpRequest,
                            HttpServletResponse httpResponse){

        boolean novoUsuario = usuario.getId() == null;

        Usuario usuarioSalvo = usuarioCrudService.salvar(usuario);

        return ResponseEntity
                .status(novoUsuario? HttpStatus.CREATED : HttpStatus.OK)
                .body(usuarioSalvo);
    }

    @GetMapping("/api/v1/usuario")
    public ResponseEntity<Page<Usuario>> buscaPaginado(Pageable pageable){

        Page<Usuario> paginaUsuarios = usuarioCrudService.buscaPaginado(pageable);

        return ResponseEntity
        .status(HttpStatus.OK)
        .body(paginaUsuarios);
    }

    }


