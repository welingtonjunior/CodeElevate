package com.fagundes.catalogodosabio.adapter.out;

import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.port.out.BookRepositoryPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryAdapter implements BookRepositoryPort {

    private final SpringDataBookRepository repository;

    public BookRepositoryAdapter(SpringDataBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> findByGenre(String genre, int page, int size) {
        return repository.findByGenreContainingIgnoreCase(genre, PageRequest.of(page, size)).getContent();
    }

    @Override
    public List<Book> findByAuthor(String author, int page, int size) {
        return repository.findByAuthorContainingIgnoreCase(author, PageRequest.of(page, size)).getContent();
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public long countByGenre(String genre) {
        return repository.countByGenreContainingIgnoreCase(genre);
    }

    @Override
    public long countByAuthor(String author) {
        return repository.countByAuthorContainingIgnoreCase(author);
    }
}
