package br.com.projetos.Board_De_Tarefas.repositories;

import br.com.projetos.Board_De_Tarefas.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
