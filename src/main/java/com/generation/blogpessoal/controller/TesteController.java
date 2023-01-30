package com.generation.blogpessoal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TesteController {

    @GetMapping
    public String teste(){
        return "O teste deu bom";
    }
}
