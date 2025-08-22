package br.com.projetos.Board_De_Tarefas.repositories;

import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import br.com.projetos.Board_De_Tarefas.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {

    List<Task> findByBoardId(Long boardId);

}
