package br.com.xpto.csb.entidades;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 100)
    @NotNull    
    private String nome;
    @NotNull
    private String cep;
    @NotNull
    private String logradouro;
    @NotNull
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    private String complemento;
    @NotNull
    private String telefone;
    @NotNull
    private String email;
    private Integer nivel;
    @ManyToOne
    @JoinColumn(name = "customer_success_id")
    @NotNull
    private CustomerSuccess customerSuccess;
}
