package br.com.projetos.Board_De_Tarefas.mappers;

import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskRequest;
import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;
import br.com.projetos.Board_De_Tarefas.entities.Task;
import br.com.projetos.Board_De_Tarefas.repositories.BoardColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskMapper {


    public Task toTask(TaskRequest request) {
        Task task = new Task();
        task.setName(request.name());
        task.setDescription(request.description());
        task.setCreatedAt(LocalDate.now());
        task.setDeadline(request.deadline());
        return task;
    }

    public TaskResponse toResponse(Task task){
        return  new TaskResponse(
                task.getName(),
                task.getDescription(),
                task.getDeadline()
        );
    }

}
