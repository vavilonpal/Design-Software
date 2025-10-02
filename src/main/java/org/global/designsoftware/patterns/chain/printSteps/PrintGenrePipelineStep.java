package org.global.designsoftware.patterns.chain.printSteps;

import org.global.designsoftware.patterns.chain.PipelineStep;
import org.global.designsoftware.patterns.chain.context.MovieContext;
import org.springframework.stereotype.Component;

@Component
public class PrintGenrePipelineStep implements PipelineStep<MovieContext> {
    @Override
    public void execute(MovieContext movieContext) {
        System.out.println("Genre: " + movieContext.getMovie().getGenre().toString());
        introspect();
    }

    @Override
    public void introspect() {
        System.out.println(this.getClass().getSimpleName()+ ": step is completed");
    }
}
