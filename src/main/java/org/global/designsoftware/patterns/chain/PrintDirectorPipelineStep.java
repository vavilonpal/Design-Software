package org.global.designsoftware.patterns.chain;

import org.springframework.stereotype.Component;

@Component
public class PrintDirectorPipelineStep implements PipelineStep<MovieContext>  {
    @Override
    public void execute(MovieContext movieContext) {
        System.out.println("Director: " + movieContext.getMovie().getDirector());
    }

    @Override
    public void Introspect() {

    }
}
