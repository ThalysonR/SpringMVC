package br.com.spring.loja.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Usuario {
    private String email;
    private String senha;
    private List<Role> permissoes = new ArrayList<>();
}
