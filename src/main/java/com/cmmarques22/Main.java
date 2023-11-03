package com.cmmarques22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    record MovieRequestById(
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
        movieRepository.deleteById(id );
    }


    //edit customer challenge

    @RequestMapping(method = RequestMethod.PUT, path = "{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Integer id,
            NewMovieRequest request,
            @RequestParam (required = false) String title,
            @RequestParam (required = false) Integer rating,
            @RequestParam (required = false) String genre
            ) {
        movieRepository.findById(id);

        Movie movie = new Movie();
        movie.setTitle(request.title());
        movie.setRating(request.rating());
        movie.setGenre(request.genre());
        movieRepository.save(movie);

    }





//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        return new GreetResponse(
//                "Hello Spring",
//
//                List.of("Golang(loading)", "Java", "Python"),
//
//                new Person("Camané", 32, 1.87)
//        );
//    }
//
//    record Person(String name, int age, double height) {}
//
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//    ){
//
//    }
    // docker exec -it postgres bash
    // psql -U username
    // \l to list
    // \c \\d movie (database customer) or \dt database table
    // CREATE DATABASE movie, ctrl d to exit x2



//or
// docker ps



//        static class GreetResponse {
//        private final String greet;
//
//        public GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//            public String getGreet() {
//                return greet;
//            }
//
//            @Override
//            public String toString() {
//                return "GreetResponse{" +
//                        "greet='" + '\'' +
//                        '}';
//            }
//
//            @Override
//            public boolean equals(Object o) {
//                if (this == o) return true;
//                if (o == null || getClass() != o.getClass()) return false;
//                GreetResponse that = (GreetResponse) o;
//                return Objects.equals(greet, that.greet);
//            }
//
//            @Override
//            public int hashCode() {
//                return Objects.hash(greet);
//            }
//        }


}
