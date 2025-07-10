package com.fagundes.catalogodosabio.application;

import com.fagundes.catalogodosabio.domain.exception.BookNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByAuthorNotFoundException;
import com.fagundes.catalogodosabio.domain.exception.BooksByGenreNotFoundException;
import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.port.out.BookRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    @InjectMocks
    private BookService bookService;

    /**
     * Testa se o método getAllBooks retorna corretamente uma lista de livros.
     */
    @Test
    public void testGetAllBooks_ReturnsList() {
        List<Book> books = List.of(
                new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"),
                new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434")
        );

        Mockito.when(bookRepositoryPort.findAll(0, 10)).thenReturn(books);

        List<Book> result = bookService.getAllBooks(0, 10).getContent();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Book One", result.get(0).getTitle());
    }

    /**
     * Testa se o método getBookByid retorna o livro correto quando encontrado.
     */
    @Test
    public void testGetBookById_Found() {
        Book book = new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434");

        Mockito.when(bookRepositoryPort.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookByid(1L);

        Assertions.assertEquals("Book One", result.getTitle());
    }

    /**
     * Testa se o método getBookByid lança uma exceção quando o livro não é encontrado.
     */

    @Test
    public void testGetBookById_NotFound() {
        Mockito.when(bookRepositoryPort.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookByid(1L);
        });
    }
    /**
     * Testa se o método getBooksByGenre retorna livros quando encontrados para o gênero especificado.
     */
    @Test
    public void testGetBooksByGenre_Found() {
        List<Book> books = List.of(new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"));

        Mockito.when(bookRepositoryPort.findByGenre("Genre One", 1, 0)).thenReturn(books);

        List<Book> result = bookService.getBooksByGenre("Genre One", 1, 0).getContent();

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Genre One", result.get(0).getGenre());
    }

    /**
     * Testa se o método getBooksByGenre lança exceção quando nenhum livro é encontrado para o gênero especificado.
     */
    @Test
    public void testGetBooksByGenre_NotFound() {
        Mockito.when(bookRepositoryPort.findByGenre("sciFi", 1, 0)).thenReturn(List.of());
        Assertions.assertThrows(BooksByGenreNotFoundException.class, () -> {
            bookService.getBooksByGenre("sciFi", 1, 0);
        });

    }

    /**
     * Testa se o método getBooksByAuthor retorna livros quando encontrados para o autor especificado.
     */
    @Test
    public void testGetBooksByAuthor_Found() {
        List<Book> books = List.of(new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"));

        Mockito.when(bookRepositoryPort.findByAuthor("Author One", 1, 0)).thenReturn(books);

        List<Book> result = bookService.getBooksByAuthor("Author One", 1, 0).getContent();

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Author One", result.get(0).getAuthor());
    }

    /**
     * Testa se o método getBooksByAuthor lança exceção quando nenhum livro é encontrado para o autor especificado.
     */

    @Test
    public void testGetBooksByAuthor_NotFound() {
        Mockito.when(bookRepositoryPort.findByAuthor("unknown", 1, 0)).thenReturn(List.of());
        Assertions.assertThrows(BooksByAuthorNotFoundException.class, () -> {
            bookService.getBooksByAuthor("unknown", 1, 0);
        });

    }
}
