package com.web3.peconsult.controllers;

import com.web3.peconsult.dtos.ResultadoRequestDTO;
import com.web3.peconsult.entities.Candidato;
import com.web3.peconsult.services.CandidatoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidatos")
@CrossOrigin(origins = "*")
public class CandidatoController {
    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public Candidato getResultado(@RequestBody ResultadoRequestDTO request) {
        return candidatoService.getResultado(request.getNome(), request.getCargo(), request.getAno());
    }
}
