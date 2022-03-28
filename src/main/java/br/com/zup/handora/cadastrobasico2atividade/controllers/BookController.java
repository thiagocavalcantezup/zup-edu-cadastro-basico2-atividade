package br.com.zup.handora.cadastrobasico2atividade.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.cadastrobasico2atividade.models.Book;
import br.com.zup.handora.cadastrobasico2atividade.models.BookDTO;
import br.com.zup.handora.cadastrobasico2atividade.repositories.BookRepository;

@RestController
@RequestMapping(BookController.BASE_URI)
public class BookController {

    public final static String BASE_URI = "/books";

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Void> postMethodName(@RequestBody @Valid BookDTO bookDTO,
                                               UriComponentsBuilder uriComponentsBuilder) {
        Book book = bookRepository.save(bookDTO.toBook());

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(book.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
