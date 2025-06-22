package com.fagundes.catalogodosabio.adapter.out;

import com.fagundes.catalogodosabio.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataBookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenre(String genre);

    List<Book> findByAuthor(String author);
}
