package br.com.zup.handora.cadastrobasico2atividade.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.ISBN;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 4000)
    private String descricao;

    @Column(nullable = false)
    @Past
    private LocalDate dataPublicacao;

    @ISBN(type = ISBN.Type.ANY)
    private String isbn;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Livro() {}

    public Livro(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

}
