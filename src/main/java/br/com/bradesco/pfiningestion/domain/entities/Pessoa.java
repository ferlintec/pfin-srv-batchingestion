package br.com.bradesco.pfiningestion.domain.entities;

import lombok.Data;

@Data
public class Pessoa {
    private Integer id;
    private String nome;
    private String sobrenome;
}
