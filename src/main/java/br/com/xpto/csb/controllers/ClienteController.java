package br.com.xpto.csb.controllers;

import br.com.xpto.csb.dtos.ClienteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.xpto.csb.entidades.Cliente;
import br.com.xpto.csb.services.ClienteService;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente clienteCriado = clienteService.criarCliente(clienteRequest);
        return ResponseEntity.created(URI.create("/clientes/" + clienteCriado.getId()))
                .body(clienteCriado);
    }
}
