package br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos;

import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;


import java.util.List;

public record BoardColumnResponse(

        String name,
        List<TaskResponse> tasks

) {
}
