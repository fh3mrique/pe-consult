package com.web3.peconsult.repositories;

import com.web3.peconsult.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    List<Candidato> findByNomeAndCargoAndAno(String nome, String cargo, int ano);
}
