package br.com.xpto.csb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.csb.entidades.CustomerSuccess;
import br.com.xpto.csb.enums.ExperienciaCustomer;
import br.com.xpto.csb.repositories.CustomerSuccessRepository;

@Service
public class CustomerSuccessService {
    @Autowired
    CustomerSuccessRepository customerSuccessRepository;

    public CustomerSuccess buscarCustomerSuccess(ExperienciaCustomer experiencia){
        List<CustomerSuccess> customerSuccesList = customerSuccessRepository.pesquisarPorExperiencia(experiencia);
        if(!customerSuccesList.isEmpty()){
            return customerSuccesList.get(0);
        } else{
            return null;
        }
    }
}
