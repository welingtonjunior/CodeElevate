package com.fagundes.catalogodosabio.domain.port.out;

import com.fagundes.catalogodosabio.domain.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Interface que define os contratos para interação com o repositório de livros.
 * Ela provê métodos para consultar livros e salvar novos livros.
 */
public interface BookRepositoryPort {

    /**
     * Recupera uma lista de livros com paginação.
     *
     * @param page Número da página (começa do 0).
     * @param size Número de itens por página.
     * @return Lista de livros paginada.
     */
    List<Book> findAll(int page, int size);

    /**
     * Recupera um livro pelo seu ID.
     *
     * @param id ID único do livro.
     * @return Um {@link Optional} contendo o livro encontrado, ou vazio caso não exista.
     */
    Optional<Book> findById(Long id);

    /**
     * Recupera uma lista de livros de um determinado gênero.
     *
     * @param genre Gênero do livro (ex: "Fantasia", "Romance").
     * @return Lista de livros que pertencem ao gênero solicitado.
     */
    List<Book> findByGenre(String genre);

    /**
     * Recupera uma lista de livros de um determinado autor.
     *
     * @param author Nome do autor do livro.
     * @return Lista de livros do autor solicitado.
     */
    List<Book> findByAuthor(String author);

    /**
     * Salva um livro no repositório.
     * Este método é utilizado para persistir um novo livro ou atualizar um existente.
     *
     * @param book O livro a ser salvo.
     * @return O livro salvo, com todos os campos preenchidos, incluindo o ID gerado.
     */
    Book save(Book book);
}
