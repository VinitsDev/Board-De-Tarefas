package br.com.projetos.Board_De_Tarefas.services;

import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardResponse;
import br.com.projetos.Board_De_Tarefas.entities.Board;
import br.com.projetos.Board_De_Tarefas.mappers.BoardColumnMapper;
import br.com.projetos.Board_De_Tarefas.mappers.BoardMapper;
import br.com.projetos.Board_De_Tarefas.mappers.TaskMapper;
import br.com.projetos.Board_De_Tarefas.repositories.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;
    private final BoardColumnMapper columnMapper;
    private final TaskMapper taskMapper;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper, BoardColumnMapper columnMapper, TaskMapper taskMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
        this.columnMapper = columnMapper;
        this.taskMapper = taskMapper;
    }

    public BoardResponse create(BoardRequest request) {
        Board board = boardMapper.toBoard(request);

        boardRepository.save(board);

        return boardMapper.toResponse(board, columnMapper, taskMapper);
    }

    public BoardResponse update(BoardRequest request, Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Board not found"));

        board.setName(request.name());

        boardRepository.save(board);

        return boardMapper.toResponse(board, columnMapper, taskMapper);
    }

    public List<BoardResponse> listAll() {
        return boardRepository.findAll().stream()
                .map(board -> boardMapper.toResponse(board, columnMapper, taskMapper))
                .toList();
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

}
