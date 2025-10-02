package org.global.designsoftware.patterns.chain.context;

import lombok.Getter;
import lombok.Setter;
import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.patterns.chain.context.ContextInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class ListOfMovieContext implements ContextInterface {
    private List<Movie> movies;
    private Movie firstMovie;
}
