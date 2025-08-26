package br.com.projetos.Board_De_Tarefas.controllers;

import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardDtos.BoardResponse;
import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;
import br.com.projetos.Board_De_Tarefas.entities.Board;
import br.com.projetos.Board_De_Tarefas.services.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@Validated
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    @Operation(summary = "Create a Board", description = "Creates a new Board")
    public ResponseEntity<BoardResponse> create(@RequestBody @Valid BoardRequest request) {
        BoardResponse response = boardService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Board", description = "Updates an existing Board by ID")
    public ResponseEntity<BoardResponse> update(@RequestBody @Valid BoardRequest request, @PathVariable("id") Long id){
        BoardResponse response = boardService.update(request, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "List all Boards", description = "Returns a list with all Boards")
    public List<BoardResponse> listAll() {
        return boardService.listAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Board", description = "Deletes a Board by ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
