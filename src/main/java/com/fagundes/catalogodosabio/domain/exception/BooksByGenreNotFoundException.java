package com.fagundes.catalogodosabio.domain.exception;

public class BooksByGenreNotFoundException extends RuntimeException {
    public BooksByGenreNotFoundException(String genre) {

        super("Nenhum livro encontrado para o genero: " + genre);
    }
}
