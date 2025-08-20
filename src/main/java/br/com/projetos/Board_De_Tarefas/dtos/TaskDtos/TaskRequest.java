package br.com.projetos.Board_De_Tarefas.dtos.TaskDtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TaskRequest(

        @NotBlank(message = "Name cannot be empty")
        String name,

        @NotBlank(message = "Description cannot be empty")
        String description,

        @NotNull(message = "Deadline cannot be empty")
        @FutureOrPresent(message = "Deadline must be during present or future")
        LocalDate deadline,

        @NotNull(message = "Column cannot be empty")
        Long columnId
) {
}
