package ru.pavel2107.otus.hw11.repository.mongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Book;
import ru.pavel2107.otus.hw11.domain.Genre;


@Repository
public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

    Mono<Void> deleteById(String id);
    Mono<Genre> save(Mono<Genre> genre);

}
