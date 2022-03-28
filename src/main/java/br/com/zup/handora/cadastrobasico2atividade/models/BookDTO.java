package br.com.zup.handora.cadastrobasico2atividade.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.ISBN;

public class BookDTO {

    @NotBlank
    @Size(max = 200)
    private String title;

    @NotBlank
    @Size(max = 4000)
    private String description;

    @NotBlank
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;

    @ISBN
    private String isbn;

    public BookDTO() {}

    public BookDTO(@NotBlank @Size(max = 200) String title,
                   @NotBlank @Size(max = 4000) String description,
                   @NotBlank @Past LocalDate publicationDate, @ISBN String isbn) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
    }

    public Book toBook() {
        String newIsbn = isbn.replaceAll("[^0-9X]", "");

        return new Book(title, description, publicationDate, newIsbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
