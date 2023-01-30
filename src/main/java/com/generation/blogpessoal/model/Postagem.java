package com.generation.blogpessoal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O atributo título é obrigatpório!")
    @Size(min = 5, max = 100, message = "O titulo deve ter no mínimo 5 e no máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message = "O atributo texto é obrigatório!")
    @Size(min = 10, max = 1000, message = "O texto deve ter no mínimo 10 e no máximo 1000 caracteres.")
    private String texto;

    @UpdateTimestamp
    private LocalDateTime data;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


}
