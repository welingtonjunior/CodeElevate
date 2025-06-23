package com.fagundes.catalogodosabio.domain.port.in;

import com.fagundes.catalogodosabio.domain.exception.BookNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByAuthorNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByGenreNotFoundException;
import com.fagundes.catalogodosabio.domain.model.Book;

import java.util.List;

/**
 * Interface que define os casos de uso para a manipulação dos livros.
 * Esta interface é parte da camada de aplicação e contém os métodos para
 * acessar e consultar os livros na base de dados.
 */
public interface BookUseCase {

    /**
     * Obtém uma lista de livros com paginação.
     *
     * @param page O número da página que deve ser recuperada.
     * @param size O número de livros por página.
     * @return Uma lista de livros da página solicitada.
     */
    List<Book> getAllBooks(int page, int size);

    /**
     * Obtém um livro pelo seu ID.
     *
     * @param id O ID do livro a ser recuperado.
     * @return O livro correspondente ao ID fornecido.
     * @throws BookNotFoundException Se o livro não for encontrado.
     */
    Book getBookByid(Long id);

    /**
     * Obtém uma lista de livros por gênero.
     *
     * @param genre O gênero dos livros a serem recuperados.
     * @return Uma lista de livros que pertencem ao gênero especificado.
     * @throws BooksByGenreNotFoundException Se nenhum livro for encontrado com o gênero fornecido.
     */
    List<Book> getBooksByGenre(String genre);

    /**
     * Obtém uma lista de livros por autor.
     *
     * @param author O autor dos livros a serem recuperados.
     * @return Uma lista de livros escritos pelo autor especificado.
     * @throws BooksByAuthorNotFoundException Se nenhum livro for encontrado com o autor fornecido.
     */
    List<Book> getBooksByAuthor(String author);
}
