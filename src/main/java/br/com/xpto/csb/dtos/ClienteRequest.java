package br.com.xpto.csb.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteRequest {

    private String nome;

    private String cpf;

    private List<TelefoneRequest> telefones;

    private List<String> emails;

    private String cep;
}
