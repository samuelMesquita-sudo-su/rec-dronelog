package org.example.dronelog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dronelog.dto.MissaoVooRequestDTO;
import org.example.dronelog.dto.MissaoVooResponseDTO;
import org.example.dronelog.model.StatusMissao;
import org.example.dronelog.service.MissaoVooService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Missao", description = "Rotas para gerenciamento de missoes")
@RestController
@RequestMapping("/missoes")
public class MissaoVooController {

    private final MissaoVooService missaoVooService;

    public MissaoVooController(MissaoVooService missaoVooService) {
        this.missaoVooService = missaoVooService;
    }

    @Operation(summary = "Listar todas as missoes")
    @GetMapping
    public List<MissaoVooResponseDTO> listar(
            @RequestParam(required = false) StatusMissao status,
            @RequestParam(required = false) String localOperacao,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrevista
    ) {
        // TODO: ligar a rota à lógica de consulta das missões.
        return missaoVooService.listar(status, localOperacao, dataPrevista);
    }

    @Operation(summary = "Buscar missao por ID")
    @GetMapping("/{id}")
    public MissaoVooResponseDTO buscarPorId(@PathVariable Long id) {
        // TODO: buscar uma missão específica.
        return missaoVooService.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar uma missao")
    @PostMapping
    public MissaoVooResponseDTO cadastrar(@Valid @RequestBody MissaoVooRequestDTO dto) {
        // TODO: registrar a missão considerando os vínculos necessários.
        return missaoVooService.cadastrar(dto);
    }

    @Operation(summary = "Atualizar os dados de uma missao")
    @PutMapping("/{id}")
    public MissaoVooResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MissaoVooRequestDTO dto) {
        // TODO: atualizar uma missão já cadastrada.
        return missaoVooService.atualizar(id, dto);
    }

    @Operation(summary = "Deletar os dados de uma missao por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        // TODO: remover uma missão quando for permitido.
        missaoVooService.deletar(id);
    }
}
