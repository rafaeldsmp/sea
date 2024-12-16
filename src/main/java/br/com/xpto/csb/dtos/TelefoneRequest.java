package br.com.xpto.csb.dtos;

import br.com.xpto.csb.enums.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefoneRequest {

    private TipoTelefone tipo;

    private String numero;
}
