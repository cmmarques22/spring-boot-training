package com.cmmarques22;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@ComponentScan(basePackages = "com.cmmarques22")
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication
@RestController
@RequestMapping("api/v1/movies/")
public class Main {

    private final MovieRepository movieRepository;

    public Main(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //System.out.println("Hello Springboot");
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    record NewMovieRequest(
            String title,
            Double rating,
            String genre
    ) {
    }


    //get the request, convert it to movie and save it
    //JSON object mapped to new movie request
    @PostMapping
    public void addMovie(
            @RequestBody NewMovieRequest request
    ) {


        Movie movie = new Movie();
        movie.setTitle(request.title());
        movie.setRating(request.rating());
        movie.setGenre(request.genre());
        movieRepository.save(movie);
    }
    //delete customer
    @RequestMapping (method = RequestMethod.DELETE, path = "{movieId}")
    public void deleteMovie(
            @PathVariable("movieId") Integer id) {

        //check if id exist before deleting?
        movieRepository.deleteById(id);
    }


    //edit customer challenge

//    @RequestMapping(method = RequestMethod.PUT, path = "{movieId}")
//    public void updateMovie(
//            @PathVariable("movieId") Integer id,
//            @RequestParam (required = false) String title,
//            @RequestParam (required = false) Integer rating,
//            @RequestParam (required = false) String genre
//            ) {
//        movieRepository.findById(id);
//
//        Movie movie = new Movie();
//        movie.setTitle(request.title());
//        movie.setRating(request.rating());
//        movie.setGenre(request.genre());
//        movieRepository.save(movie);
//
//    }

//     @PutMapping("{movieId}")
//        public void updateCustomer(@PathVariable("movieId") Integer id,
//                                   @RequestBody Movie request) {
//        Movie movie = new Movie();
//        movie.setId(id);
//        movie.setTitle(request.title());
//        movie.setRating(request.rating());
//        movie.setGenre(request.genre());
//            movieRepository.save(movie);
//        }


//    @PutMapping("{movieId}")
//    public void updateMovie(@PathVariable("movieId") Integer id, @RequestBody Movie request) {
//        Movie existingMovie = movieRepository.findById(id).orElse(null);
//
//        if (existingMovie != null) {
//            existingMovie.setTitle(request.getTitle());
//            existingMovie.setRating(request.getRating());
//            existingMovie.setGenre(request.getGenre());
//
//            movieRepository.save(existingMovie);
//        }
//    }

    @PutMapping("{movieId}")
    public void updateMovie(@PathVariable("movieId") Integer id, @RequestBody Movie request) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));

        existingMovie.setTitle(request.getTitle());
        existingMovie.setRating(request.getRating());
        existingMovie.setGenre(request.getGenre());

        movieRepository.save(existingMovie);
    }







    // docker exec -it postgres bash
    // psql -U username
    // \l to list
    // \c \\d movie (database customer) or \dt database table
    // CREATE DATABASE movie, ctrl d to exit x2



//or
// docker ps






}
