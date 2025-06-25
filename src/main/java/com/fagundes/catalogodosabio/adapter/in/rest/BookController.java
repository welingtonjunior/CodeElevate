package com.fagundes.catalogodosabio.adapter.in.rest;

import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.model.BookPage;
import com.fagundes.catalogodosabio.domain.port.in.BookUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookUseCase bookUseCase;

    public BookController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookUseCase.getBookByid(id));
    }

    @GetMapping
    public ResponseEntity<BookPage<Book>> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookUseCase.getAllBooks(page, size));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<BookPage<Book>> getBooksByGenre(@PathVariable String genre,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookUseCase.getBooksByGenre(genre, page, size));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<BookPage<Book>> getBooksByAuthor(@PathVariable String author,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookUseCase.getBooksByAuthor(author, page, size));
    }
}