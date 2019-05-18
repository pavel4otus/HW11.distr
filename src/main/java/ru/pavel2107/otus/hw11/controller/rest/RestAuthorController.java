package ru.pavel2107.otus.hw11.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Author;
import ru.pavel2107.otus.hw11.repository.mongoDB.AuthorRepository;


@RestController
public class RestAuthorController {

    private AuthorRepository repository;

    @Autowired
    public RestAuthorController(AuthorRepository repository){
        this.repository = repository;
    }

    @GetMapping( value = "/flux/authors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Author> listAuthors(){
        return repository.findAll();
    }

    @DeleteMapping( value = "/flux/authors/{id}")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable( value = "id") String id){
        return repository.deleteById(  id);
    }

    @GetMapping( value = "/flux/authors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Author> get( @PathVariable( value = "id") String id){
        return repository.findById( id);
    }

    @PostMapping( value = "/flux/authors", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Author> save(@RequestBody Mono<Author> author){
      return repository.save(author);
    }
}
