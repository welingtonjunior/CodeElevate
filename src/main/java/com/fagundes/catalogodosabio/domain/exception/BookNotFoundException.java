package com.fagundes.catalogodosabio.domain.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Livro com ID " + id + " não encontrado");
    }
}
