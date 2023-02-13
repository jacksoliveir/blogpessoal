package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @BeforeAll
    void start(){
        usuarioRepository.deleteAll();

        usuarioRepository.save( new Usuario(0L,"Luiz Silva", "lusilva@email.com", "12345678","https://image.jpg"));
        usuarioRepository.save( new Usuario(0L,"Geandro Silva", "geo@email.com", "12345678","https://image.jpg"));
        usuarioRepository.save( new Usuario(0L,"Jacque Silva", "jacque@email.com", "12345678","https://image.jpg"));
        usuarioRepository.save( new Usuario(0L,"Antonio Cunha", "antc@email.com", "12345678","https://image.jpg"));

    }
    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario(){
        Optional<Usuario> usuario = usuarioRepository.findByUsuario("geo@email.com");
        assertTrue(usuario.get().getUsuario().equals("geo@email.com"));
    }

    @Test
    @DisplayName("Restorna 3 usuarios")
    public void deveRetornarTresUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
        assertEquals(3, listaDeUsuarios.size());
        assertTrue(listaDeUsuarios.get(0).getNome().equals("Luiz Silva"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Geandro Silva"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Jacque Silva"));
    }

    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }

}
