package br.com.xpto.csb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.xpto.csb.entidades.CustomerSuccess;
import br.com.xpto.csb.enums.ExperienciaCustomer;

@Repository
public interface CustomerSuccessRepository extends JpaRepository<CustomerSuccess,Long> {
    @Query("SELECT cs FROM CustomerSuccess cs WHERE cs.experiencia = :experiencia")
    List<CustomerSuccess> pesquisarPorExperiencia(ExperienciaCustomer experiencia);
}