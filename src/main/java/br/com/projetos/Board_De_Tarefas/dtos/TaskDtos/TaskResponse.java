package br.com.projetos.Board_De_Tarefas.dtos.TaskDtos;


import java.time.LocalDate;

public record TaskResponse(

        String name,
        String description,
        LocalDate deadline

) {
}
