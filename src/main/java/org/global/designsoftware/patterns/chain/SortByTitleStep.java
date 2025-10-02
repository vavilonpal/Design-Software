package org.global.designsoftware.patterns.chain;

import org.global.designsoftware.entity.Movie;
import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class SortByTitleStep implements PipelineStep<ListOfMovieContext>{
    @Override
    public void execute(ListOfMovieContext listOfMovieContext) {
        List<Movie> sortedByTitle = listOfMovieContext.getMovies().stream()
                .sorted(Comparator.comparing(Movie::getTitle)).toList();
        listOfMovieContext.setMovies(sortedByTitle);
    }

    @Override
    public void introspect() {

    }
}
