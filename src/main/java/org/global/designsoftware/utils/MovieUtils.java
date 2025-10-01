package org.global.designsoftware.utils;

import lombok.RequiredArgsConstructor;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.patterns.MovieFieldMask;
import org.global.designsoftware.service.MovieService;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MovieUtils {

    private final MovieService movieService;

    public static boolean equalsByMask(Movie m1, Movie m2, MovieFieldMask mask) {
        if (mask.isId() && !m1.getId().equals(m2.getId())) return false;
        if (mask.isTitle() && !m1.getTitle().equals(m2.getTitle())) return false;
        if (mask.isDirector() && !m1.getDirector().equals(m2.getDirector())) return false;
        if (mask.isFees() && Float.compare(m1.getFees(), m2.getFees()) != 0) return false;
        if (mask.isGenre() && m1.getGenre() != m2.getGenre()) return false;
        return true;
    }

    public static void copyFields(Movie target, Movie source, MovieFieldMask mask) {
        if (mask.isId()) target.setId(source.getId());
        if (mask.isTitle()) target.setTitle(source.getTitle());
        if (mask.isDirector()) target.setDirector(source.getDirector());
        if (mask.isFees()) target.setFees(source.getFees());
        if (mask.isGenre()) target.setGenre(source.getGenre());
    }
    public void copyData(Movie sourceMovie, MovieFieldMask equalsMask, MovieFieldMask copyMask) {
        for (Movie movie : movieService.findAll()) {
            if (equalsByMask(sourceMovie, movie, equalsMask)){
                copyFields(movie, sourceMovie, copyMask);
                movieService.updateByMask(movie, movie.getId());
            }
        }

    }

    public static Movie print(Movie movie, MovieFieldMask fieldMask){
        Movie movieMask = new Movie();
        if (fieldMask.isId()){
            movieMask.setId(movie.getId());
            System.out.println("Id: " + movie.getId());
        }
        if (fieldMask.isTitle()){
            movieMask.setTitle(movie.getTitle());
            System.out.println("Title: " + movie.getTitle());
        }
        if (fieldMask.isDirector()){
            movieMask.setDirector(movie.getDirector());
            System.out.println("Author: " + movie.getDirector());
        }
        if (fieldMask.isFees()){
            movieMask.setFees(movie.getFees());
            System.out.println("Fees: " + movie.getFees());
        }
        if (fieldMask.isGenre()){
            movieMask.setGenre(movie.getGenre());
            System.out.println("Genre: " + movie.getGenre());
        }
        return movieMask;
    }
}
