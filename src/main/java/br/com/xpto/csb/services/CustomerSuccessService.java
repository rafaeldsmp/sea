package br.com.xpto.csb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.xpto.csb.entidades.CustomerSuccess;
import br.com.xpto.csb.enums.ExperienciaCustomer;
import br.com.xpto.csb.repositories.CustomerSuccessRepository;

@Service
public class CustomerSuccessService {
    @Autowired
    CustomerSuccessRepository customerSuccessRepository;

        public CustomerSuccess buscarCustomerSuccess(Long id){
        @SuppressWarnings("null")
        Optional<CustomerSuccess> customerSuccess = customerSuccessRepository.findById(id);
        return customerSuccess.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }

    @SuppressWarnings("null")
    public CustomerSuccess inserirCliente(CustomerSuccess customerSuccess){
        return customerSuccessRepository.save(customerSuccess);
    }

    public CustomerSuccess buscarCustomerSuccess(ExperienciaCustomer experiencia){
        List<CustomerSuccess> customerSuccesList = customerSuccessRepository.pesquisarPorExperiencia(experiencia);
        if(!customerSuccesList.isEmpty()){
            return customerSuccesList.get(0);
        } else{
            return null;
        }
    }
}
