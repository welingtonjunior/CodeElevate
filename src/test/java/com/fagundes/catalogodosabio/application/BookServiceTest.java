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

    @Test
    public void testGetAllBooks_ReturnsList() {
        List<Book> books = List.of(
                new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"),
                new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434")
        );

        Mockito.when(bookRepositoryPort.findAll(0, 10)).thenReturn(books);

        List<Book> result = bookService.getAllBooks(0, 10);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Book One", result.get(0).getTitle());
    }

    @Test
    public void testGetBookById_Found() {
        Book book = new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434");

        Mockito.when(bookRepositoryPort.findById(1L)).thenReturn(Optional.of(book));

        Book result = bookService.getBookByid(1L);

        Assertions.assertEquals("Book One", result.getTitle());
    }

    @Test
    public void testGetBookById_NotFound() {
        Mockito.when(bookRepositoryPort.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookByid(1L);
        });
    }

    @Test
    public void testGetBooksByGenre_Found() {
        List<Book> books = List.of(new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"));

        Mockito.when(bookRepositoryPort.findByGenre("Genre One")).thenReturn(books);

        List<Book> result = bookService.getBooksByGenre("Genre One");

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Genre One", result.get(0).getGenre());
    }

    @Test
    public void testGetBooksByGenre_NotFound() {
        Mockito.when(bookRepositoryPort.findByGenre("SciFi")).thenReturn(List.of());

        Assertions.assertThrows(BooksByGenreNotFoundException.class, () -> {
            bookService.getBooksByGenre("sciFi");
        });
    }

    @Test
    public void testGetBooksByAuthor_Found() {
        List<Book> books = List.of(new Book(1L, "Book One", "Author One", "Genre One", "ffdsf",123213434, "123213434"));

        Mockito.when(bookRepositoryPort.findByAuthor("Author One")).thenReturn(books);

        List<Book> result = bookService.getBooksByAuthor("Author One");

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals("Author One", result.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByAuthor_NotFound() {
        Mockito.when(bookRepositoryPort.findByAuthor("Unknown")).thenReturn(List.of());

        Assertions.assertThrows(BooksByAuthorNotFoundException.class, () -> {
            bookService.getBooksByAuthor("unknown");
        });
    }
}
