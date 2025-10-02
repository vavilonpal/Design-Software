package org.global.designsoftware.patterns.chain;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;

@RequiredArgsConstructor
public class LogStepExecutingTime implements PipelineStep<ListOfMovieContext>{

    private final PipelineStep<ListOfMovieContext> pipelineStep;

    @Override
    public void execute(ListOfMovieContext listOfMovieContext) {
        pipelineStep.introspect();

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pipelineStep.execute(listOfMovieContext);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start) + " ms");

    }

    @Override
    public void introspect() {

    }
}
