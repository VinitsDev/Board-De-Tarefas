package br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardColumnRequest(

        @NotBlank(message = "Name cannot be empty")
        String name,

        @NotNull(message = "Board cannot be empty")
        Long boardId

) {
}
