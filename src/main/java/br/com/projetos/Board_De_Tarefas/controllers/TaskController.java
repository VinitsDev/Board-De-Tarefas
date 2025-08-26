package br.com.projetos.Board_De_Tarefas.controllers;

import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskRequest;
import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;
import br.com.projetos.Board_De_Tarefas.entities.Task;
import br.com.projetos.Board_De_Tarefas.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Creates a task", description = "Creates a new Task")
    public ResponseEntity<TaskResponse> create(@RequestBody @Valid TaskRequest request) {
        TaskResponse response = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task", description = "Updates a task by ID")
    public ResponseEntity<TaskResponse> update(@RequestBody @Valid TaskRequest request,@PathVariable("id") Long id) {
        TaskResponse response = taskService.update(request, id);
        return  ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "List all Tasks", description = "Returns a list with all Tasks")
    public List<TaskResponse> listAll() {
        return taskService.list();
    }

    @GetMapping("/column/{id}")
    @Operation(summary = "List Tasks by Column ID", description = "Returns a list with all Tasks in a specific Column")
    public List<TaskResponse> listByColumn(@PathVariable("id")Long id) {
        return taskService.listByColumn(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a Task", description = "Deletes a Task by ID")
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
