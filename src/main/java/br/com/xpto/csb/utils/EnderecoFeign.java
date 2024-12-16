package br.com.xpto.csb.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "enderecoFeign", url = "https://viacep.com.br/ws")
public interface EnderecoFeign {
    @GetMapping("/{cep}/json")
    EnderecoResponse buscaEnderecoCep(@PathVariable("cep") String cep);
}
