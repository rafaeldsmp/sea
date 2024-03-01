package br.com.xpto.csb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.csb.entidades.Cliente;
import br.com.xpto.csb.entidades.CustomerSuccess;
import br.com.xpto.csb.enums.ExperienciaCustomer;
import br.com.xpto.csb.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CustomerSuccessService customerSuccessService;    

    @SuppressWarnings("null")
    public void cadastrarCliente(Cliente cliente){
        if(cliente.getNivel() == null || cliente.getNivel() <= 50){
            CustomerSuccess idCustomerSuccess = customerSuccessService.buscarCustomerSuccess(ExperienciaCustomer.INICIANTE);
            cliente.setCustomerSuccess(idCustomerSuccess);
            clienteRepository.save(cliente);
        }
        else{
            CustomerSuccess idCustomerSuccess = customerSuccessService.buscarCustomerSuccess(ExperienciaCustomer.PROFICIENTE);
            cliente.setCustomerSuccess(idCustomerSuccess);
            clienteRepository.save(cliente);
        }
    }
}
