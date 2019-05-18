package ru.pavel2107.otus.hw11.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Book;
import ru.pavel2107.otus.hw11.repository.mongoDB.BookRepository;

@RestController
public class RestBookController {

    private BookRepository repository;

    @Autowired
    public RestBookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping( value = "/flux/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Book> listBooks(){
        return repository.findAll();
    }

    @DeleteMapping( value = "/flux/books/{id}")
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable( value = "id") String id){
        return repository.deleteById( id);
    }


    @GetMapping( value = "/flux/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Book> get( @PathVariable( value = "id") String id){
        return repository.findById( id);
    }

    @PostMapping( value = "/flux/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Book> save(@RequestBody Mono<Book> book){
        return repository.save( book);
    }


}
