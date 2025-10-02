package org.global.designsoftware.patterns.chain;

import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;
import org.springframework.stereotype.Component;

@Component
public class FindFirstElementByTitleSortedListStep implements PipelineStep<ListOfMovieContext> {
    @Override
    public void execute(ListOfMovieContext listOfMovieContext) {
        listOfMovieContext.setFirstMovie(listOfMovieContext.getMovies().get(1));
    }

    @Override
    public void introspect() {

    }
}
