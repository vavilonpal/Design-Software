package org.global.designsoftware.patterns.chain.printSteps;

import org.global.designsoftware.patterns.chain.pipeline.PipelineStep;
import org.global.designsoftware.patterns.chain.context.MovieContext;
import org.springframework.stereotype.Component;

@Component
public class PrintDirectorPipelineStep implements PipelineStep<MovieContext> {
    @Override
    public void execute(MovieContext movieContext) {
        System.out.println("Director: " + movieContext.getMovie().getDirector());
        introspect();
    }

    @Override
    public void introspect() {
        System.out.println(this.getClass().getSimpleName()+ ": step is completed");
    }
}
