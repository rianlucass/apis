package com.br.apirest.biblioteca.service;

import com.br.apirest.biblioteca.dtos.ResponseUsuarioDTO;
import com.br.apirest.biblioteca.models.Usuario;
import com.br.apirest.biblioteca.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseUsuarioDTO salvar(ResponseUsuarioDTO usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNome((usuarioDto.getNome()));

        Usuario salvo = usuarioRepository.save(usuario);

        return toDTO(salvo);
    }

    public List<ResponseUsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private ResponseUsuarioDTO toDTO(Usuario usuario) {
        ResponseUsuarioDTO dto = new ResponseUsuarioDTO();
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        return dto;
    }


}
