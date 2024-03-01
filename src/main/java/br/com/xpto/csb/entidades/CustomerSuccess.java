package br.com.xpto.csb.entidades;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.xpto.csb.enums.ExperienciaCustomer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_customer_success")
@Getter
@Setter
public class CustomerSuccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 100)
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ExperienciaCustomer experiencia;  
    @Column(nullable = false)
    private boolean ausencia;
    @OneToMany(mappedBy = "customerSuccess")
    private List<Cliente> clientes;

}
