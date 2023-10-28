package com.crud.crud.domain;

import lombok.Data;

@Data
public class Cidadao {
    private Integer id;
    private String nome;
    private String email;
    private String celular;

    public Cidadao(){
    }

    public Cidadao(Integer id, String nome, String email, String celular){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }
}
