package org.global.designsoftware.patterns.chain;

import lombok.Getter;
import lombok.Setter;
import org.global.designsoftware.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ListOfMovieContext implements ContextInterface {
    private List<Movie> movies;
    private Movie firstMovie;
}
