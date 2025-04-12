package com.br.rianlucas.cursos.services;

import com.br.rianlucas.cursos.dtos.AlunoRequestDTO;
import com.br.rianlucas.cursos.dtos.AlunoResponseDTO;
import com.br.rianlucas.cursos.models.Aluno;
import com.br.rianlucas.cursos.models.Curso;
import com.br.rianlucas.cursos.repositories.AlunoRepository;
import com.br.rianlucas.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public AlunoResponseDTO salvar(AlunoRequestDTO dto) {
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso nao encontrado"));

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCurso(curso);
        aluno = alunoRepository.save(aluno);

        AlunoResponseDTO responseDTO = new AlunoResponseDTO();
        responseDTO.setId(aluno.getId());
        responseDTO.setNome(aluno.getNome());
        responseDTO.setCurso(aluno.getCurso().getNome());
        return responseDTO;
    }

    public List<AlunoResponseDTO> listar() {
        return alunoRepository.findAll().stream().map(aluno -> {
            AlunoResponseDTO dto = new AlunoResponseDTO();
            dto.setId(aluno.getId());
            dto.setCurso(aluno.getCurso().getNome());
            dto.setNome(aluno.getNome());
            return dto;
        }).collect(Collectors.toList());
    }

}
