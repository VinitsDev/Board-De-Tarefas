package br.com.projetos.Board_De_Tarefas.controllers;


import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnRequest;
import br.com.projetos.Board_De_Tarefas.dtos.BoardColumnDtos.BoardColumnResponse;
import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.services.BoardColumnService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/columns")
@Validated
public class BoardColumnController {

    private final BoardColumnService boardColumnService;

    public BoardColumnController(BoardColumnService boardColumnService) {
        this.boardColumnService = boardColumnService;
    }

    @PostMapping
    @Operation(summary = "Create a Column", description = "Creates a new Column")
    public ResponseEntity<BoardColumnResponse> create(@RequestBody @Valid BoardColumnRequest request) {
        BoardColumnResponse response = boardColumnService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Column", description = "Updates a existing Column by ID")
    public ResponseEntity<BoardColumnResponse> update(@RequestBody @Valid BoardColumnRequest request, @PathVariable("id") Long id) {
        BoardColumnResponse response = boardColumnService.update(request, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/board/{id}")
    @Operation(summary = "List all Columns from a Board", description = "Lists all Columns from a specific Board")
    public List<BoardColumnResponse> listByBoard(@PathVariable("id") Long id){
        return boardColumnService.listByBoard(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Column", description = "Deletes a Column by ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boardColumnService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
