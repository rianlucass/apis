package com.br.rianlucas.cursos.services;

import com.br.rianlucas.cursos.dtos.CursoRequestDTO;
import com.br.rianlucas.cursos.dtos.CursoResponseDTO;
import com.br.rianlucas.cursos.models.Curso;
import com.br.rianlucas.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public CursoResponseDTO salvar(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso = cursoRepository.save(curso);

        CursoResponseDTO responseDTO = new CursoResponseDTO();
        responseDTO.setId(curso.getId());
        responseDTO.setNome(curso.getNome());
        responseDTO.setCargaHoraria(curso.getCargaHoraria());
        return responseDTO;
    }

    public List<CursoResponseDTO> listar() {
        return cursoRepository.findAll().stream().map(curso -> {
            CursoResponseDTO responseDTO = new CursoResponseDTO();
            responseDTO.setId(curso.getId());
            responseDTO.setNome(curso.getNome());
            responseDTO.setCargaHoraria(curso.getCargaHoraria());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public CursoResponseDTO atualizar(Long id, CursoRequestDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("curso não encontrado"));

        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setNome(dto.getNome());
        curso = cursoRepository.save(curso);

        CursoResponseDTO responseDTO = new CursoResponseDTO();
        responseDTO.setId(curso.getId());
        responseDTO.setNome(curso.getNome());
        responseDTO.setCargaHoraria(curso.getCargaHoraria());

        return responseDTO;
    }

    public boolean deletarCurso(Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isEmpty()) {
            return false;
        }
        cursoRepository.deleteById(id);
        return true;
    }

}
