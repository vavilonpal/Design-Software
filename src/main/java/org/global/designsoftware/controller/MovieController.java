package org.global.designsoftware.controller;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.printer.MovieUtils;
import org.global.designsoftware.printer.patterns.MovieFieldMask;
import org.global.designsoftware.printer.repository.MovieRepository;
import org.global.designsoftware.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    private final MovieFieldMask titleEqualsMask;
    private final MovieFieldMask directorAndGenre;
    private final MovieFieldMask copyMaskByDirectorAndFees;

   @GetMapping("/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title){
        Movie movie = movieService.findByTitle(title);
        Movie movieMask = MovieUtils.print(movie, directorAndGenre);
        return ResponseEntity.ok(movieMask);
    }

    @PutMapping("/copy")
    public ResponseEntity<?> copyDataByTitleEquals_AndCopyMaskByDirector_AndFees(@RequestBody Movie sourceMovie){
        if (sourceMovie == null){
            return ResponseEntity.badRequest().build();
        }

        movieService.copyData(sourceMovie, titleEqualsMask, copyMaskByDirectorAndFees);
        return ResponseEntity.ok("Successful copy!!");
    }*/



}
