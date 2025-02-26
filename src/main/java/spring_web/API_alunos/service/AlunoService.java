package spring_web.API_alunos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_web.API_alunos.DTOS.AlunoDTO;
import spring_web.API_alunos.exceptions.AlunoNotFoundException;
import spring_web.API_alunos.exceptions.AlunoNullException;
import spring_web.API_alunos.model.Aluno;
import spring_web.API_alunos.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public AlunoDTO save(AlunoDTO alunoDTO) {
        if (alunoDTO.getNome() == null || alunoDTO.getEmail() == null || alunoDTO.getCpf() == null) {
            throw new AlunoNullException();
        }
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setCpf(alunoDTO.getCpf());
        Aluno savedAluno = repository.save(aluno);
        return new AlunoDTO(savedAluno.getId(), savedAluno.getNome(), savedAluno.getEmail(), savedAluno.getCpf());
    }

    public AlunoDTO findById(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

    public List<AlunoDTO> findAll() {
        List<Aluno> alunos = repository.findAll();
        return alunos.stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf()))
                .collect(Collectors.toList());
    }

    public boolean deleteAluno(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        throw new AlunoNotFoundException(id);
    }

    public AlunoDTO updateAluno(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> alunoOptional = repository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(alunoDTO.getNome());
            aluno.setEmail(alunoDTO.getEmail());
            aluno.setCpf(alunoDTO.getCpf());
            Aluno updatedAluno = repository.save(aluno);
            return new AlunoDTO(updatedAluno.getId(), updatedAluno.getNome(), updatedAluno.getEmail(), updatedAluno.getCpf());
        }
        throw new AlunoNotFoundException(id);
    }
}