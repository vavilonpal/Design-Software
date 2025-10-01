package org.global.designsoftware.service;

import lombok.RequiredArgsConstructor;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.printer.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id " + id));
    }

    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found with title " + title));
    }
}
