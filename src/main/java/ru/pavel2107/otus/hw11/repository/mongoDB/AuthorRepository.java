package ru.pavel2107.otus.hw11.repository.mongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Author;


import java.util.List;

@Repository
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
    Flux<Author> findByName(String name);
    Mono<Author> save( Mono<Author> author);
    Mono<Void> deleteById( String id);
}

