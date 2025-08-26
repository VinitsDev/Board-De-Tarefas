package br.com.projetos.Board_De_Tarefas.services;

import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnResponse;
import br.com.projetos.Board_De_Tarefas.entities.Board;
import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.mappers.BoardColumnMapper;
import br.com.projetos.Board_De_Tarefas.mappers.TaskMapper;
import br.com.projetos.Board_De_Tarefas.repositories.BoardColumnRepository;
import br.com.projetos.Board_De_Tarefas.repositories.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardColumnService {

    private final BoardColumnRepository boardColumnRepository;
    private final BoardColumnMapper boardColumnMapper;
    private final BoardRepository boardRepository;
    private final TaskMapper taskMapper;

    public BoardColumnService(BoardColumnRepository boardColumnRepository, BoardColumnMapper boardColumnMapper, BoardRepository boardRepository, TaskMapper taskMapper) {
        this.boardColumnRepository = boardColumnRepository;
        this.boardColumnMapper = boardColumnMapper;
        this.boardRepository = boardRepository;
        this.taskMapper = taskMapper;
    }

    public BoardColumnResponse create(BoardColumnRequest request) {
        BoardColumn column = boardColumnMapper.toBoardColumn(request);

        Board board = boardRepository.findById(request.boardId())
                .orElseThrow(() -> new EntityNotFoundException("Board not found"));
        column.setBoard(board);

        boardColumnRepository.save(column);
        return boardColumnMapper.toResponse(column, taskMapper);
    }

    public BoardColumnResponse update(BoardColumnRequest request, Long id) {
        BoardColumn column = boardColumnRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Column not found"));

        column.setName(request.name());

        if(request.boardId()!=null){
            Board board = boardRepository.findById(request.boardId())
                    .orElseThrow(()->new EntityNotFoundException("Board not found"));
            column.setBoard(board);
        }

        boardColumnRepository.save(column);
        return boardColumnMapper.toResponse(column, taskMapper);
    }

    public List<BoardColumnResponse> listByBoard(Long id) {
        return boardColumnRepository.findByBoardId(id)
                .stream().map(column -> boardColumnMapper.toResponse(column, taskMapper)).toList();
    }

    public void deleteById(Long id) {
        boardColumnRepository.deleteById(id);
    }

}
