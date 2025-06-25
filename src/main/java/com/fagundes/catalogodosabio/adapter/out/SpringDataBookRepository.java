package com.fagundes.catalogodosabio.adapter.out;

import com.fagundes.catalogodosabio.domain.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface SpringDataBookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByGenreContainingIgnoreCase(String genre, Pageable pageable);

    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);


    long countByAuthorContainingIgnoreCase(String author);

    long countByGenreContainingIgnoreCase(String genre);
}
