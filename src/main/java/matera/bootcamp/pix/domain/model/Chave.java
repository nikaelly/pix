package matera.bootcamp.pix.domain.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
public class Chave {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoChave tipoChave;

    @Column(nullable = false)
    private String valor;

    @OneToOne(optional = false)
    private ContaCorrente contaCorrente;

}
