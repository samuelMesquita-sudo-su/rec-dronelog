package org.example.dronelog.dto;

public record DroneRequestDTO(
        String identificador,
        String modelo,
        Integer autonomiaMinutos,
        Boolean disponivel
) {
}
