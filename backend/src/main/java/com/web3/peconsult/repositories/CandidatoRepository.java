package com.web3.peconsult.repositories;

import com.web3.peconsult.entities.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    List<Candidato> findByNomeAndCargoAndAno(String nome, String cargo, int ano);

    @Query(value = "SELECT SUM(QT_VOTOS_NOMINAIS) FROM candidato_2014_pe WHERE NM_CANDIDATO = :nome AND DS_CARGO = :cargo AND ANO_ELEICAO = :ano", nativeQuery = true)
    Integer sumVotosByNomeAndCargoAndAno(@Param("nome") String nome, @Param("cargo") String cargo, @Param("ano") int ano);
}
