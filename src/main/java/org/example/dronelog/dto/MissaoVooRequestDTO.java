package org.example.dronelog.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.dronelog.model.StatusMissao;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record MissaoVooRequestDTO(
        //TODO: pedir atributos para criar registro.
        @NotBlank(message = "Insira o titulo da missao")
        String titulo,
        @NotBlank(message = "Insira o local da operacao")
        String localOperacao,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @FutureOrPresent(message = "A data so pode estar no futuro ou presente")
        LocalDate dataPrevista,
        @NotNull(message = "Insira o valor da area mapeada em KM")
        Double areaMapeadaKm2,
        @NotBlank(message = "Insira o status da missao: PLANEJADA,\n" +
                "    EM_ANDAMENTO,\n" +
                "    CONCLUIDA,\n" +
                "    CANCELADA"
        )
        StatusMissao status,
        @NotNull(message = "Insira o id do piloto")
        Long idPiloto,
        @NotNull(message = "Insira o id do drone")
        Long idDrone
) {
}
