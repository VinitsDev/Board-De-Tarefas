package br.com.projetos.Board_De_Tarefas.mappers;

import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardResponse;
import br.com.projetos.Board_De_Tarefas.entities.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BoardMapper {

    public Board toBoard(BoardRequest request){
        Board board = new Board();
        board.setName(request.name());
        board.setCreatedAt(LocalDate.now());
        return board;
    }

    public BoardResponse toResponse(Board board, BoardColumnMapper columnMapper, TaskMapper taskMapper){
        return new BoardResponse(
                board.getName(),
                board.getCreatedAt(),
                board.getColumns().
                        stream()
                        .map(column -> columnMapper.toResponse(column, taskMapper))
                        .toList()
        );
    }

}
