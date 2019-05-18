package ru.pavel2107.otus.hw11.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pavel2107.otus.hw11.domain.Genre;
import ru.pavel2107.otus.hw11.repository.mongoDB.GenreRepository;

@RestController
public class RestGenreController {

    private GenreRepository repository;

    @Autowired
    public RestGenreController(GenreRepository repository){
        this.repository = repository;
    }

    @GetMapping( value = "/flux/genres", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Genre> listGenres(){
        return repository.findAll();
    }

    @DeleteMapping( value = "/flux/genres/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable( value = "id") String id){
        return repository.deleteById( id);
    }


    @GetMapping( value = "/flux/genres/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Genre> get( @PathVariable( value = "id") String id){
        return repository.findById( id);
    }

    @PostMapping( value = "/flux/genres", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Genre> save(@RequestBody Mono<Genre>  genre){
         return  repository.save( genre);
    }
}
