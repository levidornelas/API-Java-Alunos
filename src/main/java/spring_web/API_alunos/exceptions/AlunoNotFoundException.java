package spring_web.API_alunos.exceptions;

public class AlunoNotFoundException extends RuntimeException {
    public AlunoNotFoundException(Long id) {
        super("Aluno com ID " + id + " não encontrado");
    }
}
