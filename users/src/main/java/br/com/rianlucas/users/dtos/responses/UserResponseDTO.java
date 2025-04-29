package br.com.rianlucas.users.dtos.responses;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String name,
        String email,
        String password,
        LocalDateTime createdAd
) {}
