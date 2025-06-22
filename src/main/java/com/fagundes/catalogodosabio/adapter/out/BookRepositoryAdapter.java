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
    public List<Book> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
