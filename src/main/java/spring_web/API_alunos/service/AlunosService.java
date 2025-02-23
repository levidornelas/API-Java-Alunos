package spring_web.API_alunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_web.API_alunos.exceptions.AlunoNotFoundException;
import spring_web.API_alunos.exceptions.AlunoNullException;
import spring_web.API_alunos.model.Aluno;
import spring_web.API_alunos.repository.AlunosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {
    @Autowired
    private AlunosRepository repository;

    public Aluno save(Aluno aluno){
        if(aluno.getNome() == null || aluno.getEmail() == null){
            throw new AlunoNullException();
        }
        return repository.save(aluno);
    }

    public Aluno findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
    }

    public List<Aluno> findall(){
        return repository.findAll();
    }

    public boolean excluirAluno(Long id){
        if(repository.existsById(id)){
          repository.deleteById(id);
          return true;
        }
        throw new AlunoNotFoundException(id);
    }

    public Aluno atualizarAluno(Long id, String nome, String email){
        Optional<Aluno> alunoOptional = repository.findById(id);
        if (alunoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            aluno.setEmail(email);
            aluno.setNome(nome);
            return repository.save(aluno);
        }
        throw new AlunoNotFoundException(id);
    }
}
