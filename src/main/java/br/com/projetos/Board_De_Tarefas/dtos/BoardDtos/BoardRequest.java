package br.com.projetos.Board_De_Tarefas.dtos.BoardDtos;


import jakarta.validation.constraints.NotBlank;

public record BoardRequest(

        @NotBlank(message = "Name cannot be empty")
        String name

) {
}
