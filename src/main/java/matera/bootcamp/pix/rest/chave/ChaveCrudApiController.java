package matera.bootcamp.pix.rest.chave;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Chave;
import matera.bootcamp.pix.service.chave.ChaveCrudService;

@RestController
@RequiredArgsConstructor
public class ChaveCrudApiController {

    private final ChaveCrudService chaveCrudService;

    @PostMapping("/api/v1/chave")
    public ResponseEntity<Object> salvar(@RequestBody Chave chave,
            HttpServletRequest httpRequest,
            HttpServletResponse httpResponse){

        //ver se o id não existe antes de salvar
        if(chave.getId() != null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        Chave chaveSalva = chaveCrudService.salvar(chave);

        return ResponseEntity.status(HttpStatus.CREATED).body(chaveSalva);
    }

    //criar metodo put e se o id existir ele atualiza
    @PutMapping("/api/v1/chave")
    public ResponseEntity<Chave> atualizarChave(@RequestBody Chave chave) {

        if(chave.getId() == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        Chave chaveCadastrada = chaveCrudService.salvar(chave);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(chaveCadastrada);
    }
}
