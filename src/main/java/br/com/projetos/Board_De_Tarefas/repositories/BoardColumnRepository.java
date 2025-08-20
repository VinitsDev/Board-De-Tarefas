package br.com.projetos.Board_De_Tarefas.repositories;

import br.com.projetos.Board_De_Tarefas.entities.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
}
