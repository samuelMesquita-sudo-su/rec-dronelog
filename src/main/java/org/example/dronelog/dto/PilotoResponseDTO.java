package org.example.dronelog.dto;

public record PilotoResponseDTO(
        Long idPiloto,
        String nome,
        String registroAnac,
        String email,
        Boolean ativo

) {
}
