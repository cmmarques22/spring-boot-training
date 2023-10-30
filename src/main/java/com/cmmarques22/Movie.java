package com.cmmarques22;

import java.util.Objects;

public class Movie {

    private String title;
    private Double rating;
    private String genre;

    private Integer id;

    public Movie (Integer id, String title, String genre, Double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie( ) {
    }


    public Integer getId() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(rating, movie.rating) && Objects.equals(genre, movie.genre) && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, rating, genre, id);
    }

    @Override
    public String  toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", id=" + id +
                '}';
    }
}
