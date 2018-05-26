package br.com.spring.loja.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    private String paginas;
    @ElementCollection
    private List<Preco> precos;

    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", paginas='" + paginas + '\'' +
                '}';
    }
}