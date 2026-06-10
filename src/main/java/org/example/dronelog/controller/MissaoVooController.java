package org.example.dronelog.controller;

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

    @GetMapping
    public List<MissaoVooResponseDTO> listar(
            @RequestParam(required = false) StatusMissao status,
            @RequestParam(required = false) String localOperacao,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrevista
    ) {
        // TODO: ligar a rota à lógica de consulta das missões.
        return missaoVooService.listar(status, localOperacao, dataPrevista);
    }

    @GetMapping("/{id}")
    public MissaoVooResponseDTO buscarPorId(@PathVariable Long id) {
        // TODO: buscar uma missão específica.
        return missaoVooService.buscarPorId(id);
    }

    @PostMapping
    public MissaoVooResponseDTO cadastrar(@Valid @RequestBody MissaoVooRequestDTO dto) {
        // TODO: registrar a missão considerando os vínculos necessários.
        return missaoVooService.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public MissaoVooResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody MissaoVooRequestDTO dto) {
        // TODO: atualizar uma missão já cadastrada.
        return missaoVooService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public /*ResponseEntity<Void>*/ void deletar(@PathVariable Long id) {
        // TODO: remover uma missão quando for permitido.
        missaoVooService.deletar(id);
        /*return ResponseEntity.noContent().build();*/
    }
}
