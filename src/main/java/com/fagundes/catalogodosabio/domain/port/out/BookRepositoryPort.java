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
     * Recupera uma lista de livros de um determinado gênero com paginação.
     *
     * @param genre Gênero do livro (ex: "Fantasia", "Romance").
     * @param page  Número da página.
     * @param size  Tamanho da página.
     * @return Lista paginada de livros que pertencem ao gênero solicitado.
     */
    List<Book> findByGenre(String genre, int page, int size);

    /**
     * Recupera uma lista de livros de um determinado autor com paginação.
     *
     * @param author Nome do autor do livro.
     * @param page   Número da página.
     * @param size   Tamanho da página.
     * @return Lista paginada de livros do autor solicitado.
     */
    List<Book> findByAuthor(String author, int page, int size);

    /**
     * Salva um livro no repositório.
     * Este método é utilizado para persistir um novo livro ou atualizar um existente.
     *
     * @param book O livro a ser salvo.
     * @return O livro salvo, com todos os campos preenchidos, incluindo o ID gerado.
     */
    Book save(Book book);

    long countAll();
    long countByGenre(String genre);
    long countByAuthor(String author);
}
