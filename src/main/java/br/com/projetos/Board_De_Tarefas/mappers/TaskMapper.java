package br.com.projetos.Board_De_Tarefas.mappers;

import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskRequest;
import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;
import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.entities.Task;
import br.com.projetos.Board_De_Tarefas.repositories.BoardColumnRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskMapper {

    BoardColumnRepository boardColumnRepository;

    public Task toTask(TaskRequest request){
        Task task = new Task();

        task.setName(request.name());
        task.setDescription(request.description());
        task.setCreatedAt(LocalDate.now());
        task.setDeadline(request.deadline());

        BoardColumn column = boardColumnRepository.findById(request.columnId())
                .orElseThrow(() -> new IllegalArgumentException("Column not found")) ;

        task.setColumn(column);

        return task;
    }

    public TaskResponse toResponse(Task task){
        return  new TaskResponse(
                task.getName(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getDeadline()
        );
    }

}
