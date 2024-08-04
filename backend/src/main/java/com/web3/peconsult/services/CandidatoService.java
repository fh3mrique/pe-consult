package com.web3.peconsult.services;

import com.web3.peconsult.entities.Candidato;
import com.web3.peconsult.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public Candidato getResultado(String nome, String cargo, int ano) {
        List<Candidato> resultados = candidatoRepository.findByNomeAndCargoAndAno(nome, cargo, ano);
        return resultados.isEmpty() ? null : resultados.get(0);
    }
}
