package com.fagundes.catalogodosabio.domain.port.out;

import com.fagundes.catalogodosabio.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {

    List<Book> findAll(int page, int size);
    Optional<Book> findById(Long id);
    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(String author);

    Book save(Book book);
}
