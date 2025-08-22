package br.com.projetos.Board_De_Tarefas.services;

import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskRequest;
import br.com.projetos.Board_De_Tarefas.dtos.TaskDtos.TaskResponse;
import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.entities.Task;
import br.com.projetos.Board_De_Tarefas.mappers.TaskMapper;
import br.com.projetos.Board_De_Tarefas.repositories.BoardColumnRepository;
import br.com.projetos.Board_De_Tarefas.repositories.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final BoardColumnRepository boardColumnRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, BoardColumnRepository boardColumnRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.boardColumnRepository = boardColumnRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponse create(TaskRequest request) {
        Task task = taskMapper.toTask(request);

        BoardColumn column = boardColumnRepository.findById(request.columnId())
                .orElseThrow(() -> new RuntimeException("Column not found"));

        task.setColumn(column);

        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public TaskResponse update(TaskRequest request, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));

        task.setName(request.name());
        task.setDescription(request.description());
        task.setDeadline(request.deadline());

        if (request.columnId()!=null){
            BoardColumn column = boardColumnRepository.findById(request.columnId())
                    .orElseThrow(()-> new RuntimeException("Column not found"));
            task.setColumn(column);
        }

        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public List<TaskResponse> list() {
        return taskRepository.findAll(Sort.by("createdAt").descending())
                .stream().map(taskMapper::toResponse).toList();
    }

    public List<TaskResponse> listByColumn(Long id) {
        return taskRepository.findByColumnId(id).stream().map(taskMapper::toResponse).toList();
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }


}
