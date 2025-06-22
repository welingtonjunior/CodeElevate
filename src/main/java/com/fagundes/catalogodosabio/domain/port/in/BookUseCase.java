package com.fagundes.catalogodosabio.domain.port.in;

import com.fagundes.catalogodosabio.domain.model.Book;

import java.util.List;

public interface BookUseCase {
    List<Book> getAllBooks(int page, int size);
    Book getBookByid(Long id);
    List<Book> getBooksByGenre(String genre);
    List<Book> getBooksByAuthor(String author);
}
