package br.com.projetos.Board_De_Tarefas.mappers;

import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnResponse;
import br.com.projetos.Board_De_Tarefas.entities.Board;
import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.repositories.BoardRepository;
import org.springframework.stereotype.Component;

@Component
public class BoardColumnMapper {

    BoardRepository boardRepository;

    public BoardColumn toBoardColumn (BoardColumnRequest request){
        BoardColumn column = new BoardColumn();
        column.setName(request.name());

        Board board = boardRepository.findById(request.boardId())
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        column.setBoard(board);
        return column;
    }

    public BoardColumnResponse toResponse(BoardColumn column, TaskMapper mapper){
        return new BoardColumnResponse(
                column.getName(),
                column.getTasks().stream().map(mapper::toResponse).toList()
        );
    }

}
