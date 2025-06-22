package com.fagundes.catalogodosabio.application;

import com.fagundes.catalogodosabio.domain.exception.BookNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByAuthorNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByGenreNotFoundException;
import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.port.in.BookUseCase;
import com.fagundes.catalogodosabio.domain.port.out.BookRepositoryPort;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public BookService(BookRepositoryPort bookRepositoryPort){
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    @Cacheable(value = "AllBooks", key = "T(java.lang.String).format('%d-%d', #page, #size)")
    public List<Book> getAllBooks(int page, int size) {
        return bookRepositoryPort.findAll(page, size);
    }

    @Override
    @Cacheable(value = "books", key = "#id")
    public Book getBookByid(Long id) {
        return bookRepositoryPort.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        String genreFormatted = genre.substring(0, 1).toUpperCase() + genre.substring(1);

        List<Book> books = bookRepositoryPort.findByGenre(genreFormatted);

        if (books.isEmpty()){
            throw  new BooksByGenreNotFoundException(genreFormatted);
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        String authorFormatted = author.substring(0, 1).toUpperCase() + author.substring(1);

        List<Book> books = bookRepositoryPort.findByAuthor(authorFormatted);

        if (books.isEmpty()){
            throw new BooksByAuthorNotFoundException(authorFormatted);
        }
        return books;
    }
}
