package br.com.xpto.csb.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
