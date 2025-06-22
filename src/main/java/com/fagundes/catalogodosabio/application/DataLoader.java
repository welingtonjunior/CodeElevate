package com.fagundes.catalogodosabio.application;

import com.fagundes.catalogodosabio.domain.model.Book;
import com.fagundes.catalogodosabio.domain.port.out.BookRepositoryPort;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepositoryPort bookRepositoryPort;
    private final Faker faker = new Faker(new Locale(("pt-BR")));
    private final String[] genres = {"Ficção", "Fantasia", "Romance", "Mistério", "Terror", "Ciência", "Biografia", "Autoajuda", "Tecnologia", "História"};
    private final Random random = new Random();

    public DataLoader(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }


    @Override
    public void run(String... args) throws Exception {
        if (bookRepositoryPort.findAll(0,10).isEmpty()) {
            IntStream.range(0, 200).forEach(i -> {
                Book book = new Book();
                book.setTitle(faker.book().title());
                book.setAuthor(faker.book().author());
                book.setGenre(genres[random.nextInt(genres.length)]);
                book.setDescription(faker.lorem().sentence(12));
                book.setPublishedYear(faker.number().numberBetween(1950, 2025));
                book.setIsbn(faker.code().isbn13());
                bookRepositoryPort.save(book);
            });
        }
    }
}
