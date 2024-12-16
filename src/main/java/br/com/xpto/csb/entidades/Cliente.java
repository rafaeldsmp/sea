package br.com.xpto.csb.entidades;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z\\d\\s]+$", message = "Nome deve conter apenas letras, números e espaços.")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres.")
    @NotNull(message = "Nome é obrigatório.")
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    @NotNull(message = "CPF é obrigatório.")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;

}
