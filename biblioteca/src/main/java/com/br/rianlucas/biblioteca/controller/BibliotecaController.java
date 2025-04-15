package com.br.rianlucas.biblioteca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BibliotecaController {

    @GetMapping("/ola")
    public String testar(){
        return "Olá";
    }

}
