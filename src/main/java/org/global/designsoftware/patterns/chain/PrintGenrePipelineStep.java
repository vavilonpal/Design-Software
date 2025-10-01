package org.global.designsoftware.patterns.chain;

import org.springframework.stereotype.Component;

@Component
public class PrintGenrePipelineStep implements PipelineStep<MovieContext>  {
    @Override
    public void execute(MovieContext movieContext) {
        System.out.println("Genre: " + movieContext.getMovie().getGenre().toString());
    }

    @Override
    public void Introspect() {

    }
}
