package br.com.projetos.Board_De_Tarefas.repositories;

import br.com.projetos.Board_De_Tarefas.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByColumnId(Long columnId);

}
