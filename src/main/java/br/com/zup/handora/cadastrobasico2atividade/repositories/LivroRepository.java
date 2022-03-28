package br.com.zup.handora.cadastrobasico2atividade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.cadastrobasico2atividade.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
