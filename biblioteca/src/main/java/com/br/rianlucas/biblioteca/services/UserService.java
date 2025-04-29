package com.br.rianlucas.biblioteca.services;

import com.br.rianlucas.biblioteca.dtos.request.UserRequestDTO;
import com.br.rianlucas.biblioteca.dtos.response.UserResponseDTO;
import com.br.rianlucas.biblioteca.models.User;
import com.br.rianlucas.biblioteca.repositories.LoanRepository;
import com.br.rianlucas.biblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoanRepository loanRepository;

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserResponseDTO responseDTO = new UserResponseDTO();
            responseDTO.setId(user.getId());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setName(user.getName());
            responseDTO.setNumber(user.getNumber());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public UserResponseDTO saveUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setNumber(dto.getNumber());
        user = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setNumber(user.getNumber());

        return responseDTO;
    }

/*
    public UserResponseDTO updateUser(String id, UserRequestDTO dto) {
        User user = userRepository.findById(id).orElseThrow(() ->
            new RuntimeException("User not found!"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setNumber(dto.getNumber());
        user = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setNumber(user.getNumber());
        return responseDTO;
    }

    public boolean userDelete(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }*/
}
