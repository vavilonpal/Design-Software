package org.global.designsoftware.controller;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;
import org.global.designsoftware.patterns.chain.context.MovieContext;
import org.global.designsoftware.patterns.chain.Pipeline;
import org.global.designsoftware.utils.MovieUtils;
import org.global.designsoftware.patterns.MovieFieldMask;
import org.global.designsoftware.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieUtils movieUtils;
    private final MovieService movieService;

    //Masks
    private final MovieFieldMask titleEqualsMask;
    private final MovieFieldMask directorAndGenre;
    private final MovieFieldMask copyMaskByDirectorAndFees;

    //Context
    private final MovieContext movieContext;
    private final ListOfMovieContext listOfMovieContext;

    //Pipeline
    private final Pipeline<MovieContext> printMovieInfoPipeline;
    private final Pipeline<ListOfMovieContext> findFirstElementByTitleSortMovieList;

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title) {
        Movie movie = movieService.findByTitle(title);
        Movie movieMask = MovieUtils.print(movie, directorAndGenre);
        return ResponseEntity.ok(movieMask);
    }

    @GetMapping("/first")
    public ResponseEntity<Movie> getMovieByTitle() {
        List<Movie> movies = movieService.findAll();
        listOfMovieContext.setMovies(movies);
        findFirstElementByTitleSortMovieList.execute(listOfMovieContext);

        Movie movie = listOfMovieContext.getFirstMovie();
        return ResponseEntity.ok(movie);
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.findAll();
        movies.forEach(movie ->{
            movieContext.setMovie(movie);
            printMovieInfoPipeline.execute(movieContext);
        });
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/copy")
    public ResponseEntity<?> copyDataByTitleEquals_AndCopyMaskByDirector_AndFees(@RequestBody Movie sourceMovie) {
        if (sourceMovie == null) {
            return ResponseEntity.badRequest().build();
        }

        movieUtils.copyData(sourceMovie, titleEqualsMask, copyMaskByDirectorAndFees);
        return ResponseEntity.ok("Successful copy!!");
    }





}
