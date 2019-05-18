package ru.pavel2107.otus.hw11.repository.mongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    Mono<Book> findByIsbn(String isbn);
    Flux<Book> findByName( String name);

    Flux<Book> findBookByAuthorId( String authorId);
    Flux<Book> findBookByGenreId( String genreId);

    Mono<Void> deleteById( String id);
    Mono<Book> save( Mono<Book> book);

    boolean existsByAuthorId( String authorId);
    boolean existsByGenreId( String genreId);
}
