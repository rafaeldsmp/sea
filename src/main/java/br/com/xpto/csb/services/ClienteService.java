package br.com.xpto.csb.services;

import br.com.xpto.csb.dtos.ClienteRequest;
import br.com.xpto.csb.entidades.Cliente;
import br.com.xpto.csb.entidades.Email;
import br.com.xpto.csb.entidades.Endereco;
import br.com.xpto.csb.entidades.Telefone;
import br.com.xpto.csb.utils.EnderecoFeign;
import br.com.xpto.csb.utils.EnderecoResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import br.com.xpto.csb.repositories.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final EnderecoFeign enderecoFeign;
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente criarCliente(ClienteRequest clienteRequest) {
        EnderecoResponse enderecoResponse = enderecoFeign.buscaEnderecoCep(clienteRequest.getCep());

        Endereco endereco = new Endereco();
        endereco.setCep(enderecoResponse.getCep());
        endereco.setLogradouro(enderecoResponse.getLogradouro());
        endereco.setBairro(enderecoResponse.getBairro());
        endereco.setCidade(enderecoResponse.getLocalidade());
        endereco.setUf(enderecoResponse.getUf());

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setEndereco(endereco);
        cliente.setCpf(clienteRequest.getCpf());

        List<Telefone> telefones = clienteRequest.getTelefones().stream().map(t -> {
            Telefone telefone = new Telefone();
            telefone.setTipo(t.getTipo());
            telefone.setNumero(t.getNumero());
            telefone.setCliente(cliente); // Associa o telefone ao cliente
            return telefone;
        }).collect(Collectors.toList());

        cliente.setTelefones(telefones);

        List<Email> emails = clienteRequest.getEmails().stream().map(email -> {
            Email novoEmail = new Email();
            novoEmail.setEnderecoEmail(email);
            return novoEmail;
        }).collect(Collectors.toList());
        cliente.setEmails(emails);

        return clienteRepository.save(cliente);
    }
}
