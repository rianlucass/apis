package com.br.rianlucas.cursos.controller;

import com.br.rianlucas.cursos.dtos.AlunoRequestDTO;
import com.br.rianlucas.cursos.dtos.AlunoResponseDTO;
import com.br.rianlucas.cursos.dtos.CursoRequestDTO;
import com.br.rianlucas.cursos.dtos.CursoResponseDTO;
import com.br.rianlucas.cursos.services.AlunoService;
import com.br.rianlucas.cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CursoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private CursoService cursoService;

    @PostMapping("/alunos")
    public ResponseEntity<AlunoResponseDTO> salvarAluno(@RequestBody AlunoRequestDTO dto) {
        AlunoResponseDTO criado = alunoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PostMapping("/cursos")
    public ResponseEntity<CursoResponseDTO> salvarCurso(@RequestBody CursoRequestDTO dto) {
        CursoResponseDTO criado  = cursoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("cursos/{id}")
    public ResponseEntity<CursoResponseDTO> atualizarCurso(@PathVariable Long id, @RequestBody CursoRequestDTO dto) {
        CursoResponseDTO responseDTO = cursoService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("alunos/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequestDTO dto) {
        AlunoResponseDTO responseDTO = alunoService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/alunos")
    public List<AlunoResponseDTO> listarAlunos() {
        return alunoService.listar();
    }

    @GetMapping("/cursos")
    public List<CursoResponseDTO> listarCursos() {
        return cursoService.listar();
    }

    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        boolean deletado = alunoService.deletarAluno(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        boolean deletado = cursoService.deletarCurso(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else
            return ResponseEntity.notFound().build();
    }
}
