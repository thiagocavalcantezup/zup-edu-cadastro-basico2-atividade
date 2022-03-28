package br.com.zup.handora.cadastrobasico2atividade.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.ISBN;

public class LivroDTO {

    @NotBlank
    @Size(max = 200)
    private String titulo;

    @NotBlank
    @Size(max = 4000)
    private String descricao;

    @NotNull
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_publicacao")
    private LocalDate dataPublicacao;

    @ISBN(type = ISBN.Type.ANY)
    private String isbn;

    public LivroDTO() {}

    public LivroDTO(@NotBlank @Size(max = 200) String titulo,
                    @NotBlank @Size(max = 4000) String descricao,
                    @NotBlank @Past LocalDate dataPublicacao, @ISBN String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    public Livro paraLivro() {
        String novoIsbn = null;

        if (isbn != null) {
            novoIsbn = isbn.replaceAll("[^0-9X]", "");
        }

        return new Livro(titulo, descricao, dataPublicacao, novoIsbn);
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
