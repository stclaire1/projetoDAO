package com.crud.crud.domain;

import lombok.Data;

@Data
public class Cidadao {
    private String nome;
    private String email;
    private String celular;

    public Cidadao(){
    }

    public Cidadao(String nome, String email, String celular){
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }
}
