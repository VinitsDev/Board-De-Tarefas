package br.com.projetos.Board_De_Tarefas.dtos.BoardDtos;

import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnResponse;


import java.time.LocalDate;
import java.util.List;

public record BoardResponse(

        String name,
        LocalDate createdAt,
        List<BoardColumnResponse> columns

) {
}
