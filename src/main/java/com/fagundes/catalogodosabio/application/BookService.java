package com.fagundes.catalogodosabio.application;

import com.fagundes.catalogodosabio.domain.exception.BookNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByAuthorNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByGenreNotFoundException;
import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.model.BookPage;
import com.fagundes.catalogodosabio.domain.port.in.BookUseCase;
import com.fagundes.catalogodosabio.domain.port.out.BookRepositoryPort;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public BookService(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    @Cacheable(value = "books", key = "'allBooks_' + #page + '_' + #size")
    public BookPage<Book> getAllBooks(int page, int size) {
        List<Book> books = bookRepositoryPort.findAll(page, size);
        long totalBooks = bookRepositoryPort.countAll();
        return new BookPage<>(books, page, size, totalBooks);
    }

    @Override
    @Cacheable(value = "bookById", key = "#id")
    public Book getBookByid(Long id) {
        return bookRepositoryPort.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    @Cacheable(value = "booksByGenre", key = "#genre + '_' + #page + '_' + #size")
    public BookPage<Book> getBooksByGenre(String genre, int page, int size) {
        List<Book> books = bookRepositoryPort.findByGenre(genre, page, size);
        long totalBooks = bookRepositoryPort.countByGenre(genre);
        if (books.isEmpty()) {
            throw new BooksByGenreNotFoundException(genre);
        }
        return new BookPage<>(books, page, size, totalBooks);
    }

    @Override
    @Cacheable(value = "booksByAuthor", key = "#author + '_' + #page + '_' + #size")
    public BookPage<Book> getBooksByAuthor(String author, int page, int size) {
        List<Book> books = bookRepositoryPort.findByAuthor(author, page, size);
        long totalBooks = bookRepositoryPort.countByAuthor(author);
        if (books.isEmpty()) {
            throw new BooksByAuthorNotFoundException(author);
        }
        return new BookPage<>(books, page, size, totalBooks);
    }
}
