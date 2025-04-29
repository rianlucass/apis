package br.com.rianlucas.users.services;

import br.com.rianlucas.users.dtos.requests.UserRequestDTO;
import br.com.rianlucas.users.dtos.responses.UserResponseDTO;
import br.com.rianlucas.users.exceptions.UserNotFoundException;
import br.com.rianlucas.users.models.User;
import br.com.rianlucas.users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setName(requestDTO.name());
        user.setEmail(requestDTO.email());
        user.setPassword(requestDTO.password());
        user.setCreatedAd(LocalDateTime.now());
        user = userRepository.save(user);
        UserResponseDTO responseDTO = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCreatedAd()
        );
        return responseDTO;
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserResponseDTO responseDTO = new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getCreatedAd()
            );
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public UserResponseDTO getByIdUsers(String id) {
        return userRepository.findById(id).map(user ->
            new UserResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getCreatedAd())).
                orElseThrow(() -> new UserNotFoundException(id));
    }

}
