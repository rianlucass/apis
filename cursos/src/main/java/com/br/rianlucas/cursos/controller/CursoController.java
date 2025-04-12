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

    @GetMapping("/alunos")
    public List<AlunoResponseDTO> listarAlunos() {
        return alunoService.listar();
    }

    @GetMapping("/cursos")
    public List<CursoResponseDTO> listarCursos() {
        return cursoService.listar();
    }

}
