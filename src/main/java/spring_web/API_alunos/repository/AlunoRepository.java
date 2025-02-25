package spring_web.API_alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_web.API_alunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
