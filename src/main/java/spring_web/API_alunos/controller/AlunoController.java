package spring_web.API_alunos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_web.API_alunos.DTOS.AlunoDTO;
import spring_web.API_alunos.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping(value = "/aluno")
@Tag(name = "Alunos", description = "API para gerenciamento de alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @Operation(summary = "Salva um novo aluno", description = "Cria um novo aluno e retorna os detalhes salvos.")
    @PostMapping(value = "/save")
    public ResponseEntity<AlunoDTO> salvaAluno(@RequestBody AlunoDTO alunoDTO) {
        AlunoDTO savedAluno = service.save(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAluno);
    }

    @Operation(summary = "Busca um aluno pelo ID", description = "Retorna um aluno com base no ID fornecido.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> buscaAluno(@PathVariable Long id) {
        AlunoDTO aluno = service.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @Operation(summary = "Lista todos os alunos", description = "Retorna uma lista com todos os alunos cadastrados.")
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listaAlunos() {
        List<AlunoDTO> alunos = service.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @Operation(summary = "Exclui um aluno", description = "Deleta um aluno com base no ID informado.")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletaAluno(@PathVariable Long id) {
        service.deleteAluno(id);
        return ResponseEntity.ok("Aluno com ID " + id + " excluído com sucesso.");
    }

    @Operation(summary = "Atualiza um aluno", description = "Atualiza os dados de um aluno existente.")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO updatedAluno = service.updateAluno(id, alunoDTO);
        return ResponseEntity.ok().body(updatedAluno);
    }
}