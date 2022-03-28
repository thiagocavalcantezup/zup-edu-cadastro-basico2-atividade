package br.com.zup.handora.cadastrobasico2atividade.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.cadastrobasico2atividade.repositories.BookRepository;

@RestController
@RequestMapping(BookController.BASE_URI)
public class BookController {

    public final static String BASE_URI = "/books";

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
