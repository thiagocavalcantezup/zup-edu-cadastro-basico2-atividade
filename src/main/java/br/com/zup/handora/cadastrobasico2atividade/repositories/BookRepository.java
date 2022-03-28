package br.com.zup.handora.cadastrobasico2atividade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.cadastrobasico2atividade.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
