package br.com.xpto.csb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xpto.csb.entidades.CustomerSuccess;
import br.com.xpto.csb.services.CustomerSuccessService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerSuccessResource {
    
    @Autowired
    CustomerSuccessService customerSuccessService;

    @PostMapping
    public ResponseEntity<String> inserirCustomerSuccess(@RequestBody CustomerSuccess customerSuccess) throws Exception {
        customerSuccessService.cadastrarCustomer(customerSuccess);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer cadastrado com sucesso.");
    }
}
