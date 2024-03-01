package br.com.xpto.csb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xpto.csb.entidades.Cliente;
import br.com.xpto.csb.services.ClienteService;


@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
    
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<String> inserirCliente(@RequestBody Cliente cliente) throws Exception {
        clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso.");
    }
    
}
