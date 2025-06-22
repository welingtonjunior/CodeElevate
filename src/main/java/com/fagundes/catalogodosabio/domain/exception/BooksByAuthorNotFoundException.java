package com.fagundes.catalogodosabio.domain.exception;

public class BooksByAuthorNotFoundException extends RuntimeException {
    public BooksByAuthorNotFoundException(String author) {

        super("Nenhum livro encontrado para o autor: " + author);
    }
}
