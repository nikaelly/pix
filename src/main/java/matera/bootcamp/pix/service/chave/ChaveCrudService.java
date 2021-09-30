package matera.bootcamp.pix.service.chave;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import matera.bootcamp.pix.domain.model.Chave;
import matera.bootcamp.pix.domain.model.ContaCorrente;
import matera.bootcamp.pix.domain.repository.ChaveRepository;
import matera.bootcamp.pix.domain.repository.ContaCorrenteRepository;

@Service
@RequiredArgsConstructor
public class ChaveCrudService {

    private final ChaveRepository chaveRepository;
    private final ContaCorrenteRepository contaCorrenteRepository;

    public Chave salvar(Chave chave)
    {
        if(chave.getContaCorrente().getId() == null)
            throw new RuntimeException("Chave precisa de uma conta corrente!");

        ContaCorrente contaCorrente = contaCorrenteRepository
                .findById(chave.getContaCorrente().getId())
                .orElseThrow(() -> new RuntimeException("Conta Corrente não encontrada"));

        chave.setContaCorrente(contaCorrente);
        return chaveRepository.save(chave);
    }
}
