package com.rianlucas.security.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Values {
    ADMIN(1L),
    BASIC(2L);

    Long id;

}
