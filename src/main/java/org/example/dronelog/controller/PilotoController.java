package org.example.dronelog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.dronelog.dto.PilotoRequestDTO;
import org.example.dronelog.dto.PilotoResponseDTO;
import org.example.dronelog.service.PilotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Piloto", description = "Rotas para gerenciamento de pilotos")
@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    private final PilotoService pilotoService;

    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @Operation(summary = "Listar todos os pilotos")
    @GetMapping
    public List<PilotoResponseDTO> listar(@RequestParam(required = false) String nome) {
        // TODO: adaptar a listagem para aceitar uma consulta simples.
        return pilotoService.listar(nome);
    }

    @Operation(summary = "Buscar dados de um piloto pelo ID")
    @GetMapping("/{id}")
    public PilotoResponseDTO buscarPorid(@PathVariable Long id){
        return pilotoService.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar um piloto")
    @PostMapping
    public PilotoResponseDTO cadastrar(@Valid @RequestBody PilotoRequestDTO dto){
        return pilotoService.cadastrar(dto);
    }

    @Operation(summary = "Atualizar dados de um piloto pelo ID")
    @PutMapping("/{id}")
    public PilotoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PilotoRequestDTO dto) {
        // TODO: finalizar o fluxo de atualização.
        return pilotoService.atualizar(id, dto);
    }

    @Operation(summary = "Deletar dados de um piloto pelo ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pilotoService.deletar(id);
    }
}
