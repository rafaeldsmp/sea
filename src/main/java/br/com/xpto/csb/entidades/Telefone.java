package br.com.xpto.csb.entidades;

import br.com.xpto.csb.enums.TipoTelefone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "telefone")
@Getter
@Setter
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;

    @NotNull
    private String numero;

}
