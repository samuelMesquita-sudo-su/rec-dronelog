package org.example.dronelog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.BooleanFlag;

public record PilotoRequestDTO(
        //TODO: colocar atributos que serão requisitados para registro.
        @NotBlank(message = "O nome nao pode estar vazio")
        String nome,
        @NotBlank(message = "O registro nao pode estar vazio")
        String registroAnac,
        @Email(message = "E necessario um email valido")
        @NotBlank(message = "O email nao pode estar vazio")
        String email,
        
        Boolean ativo
) {
}
