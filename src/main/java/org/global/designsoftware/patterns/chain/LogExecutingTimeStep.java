package org.global.designsoftware.patterns.chain;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.patterns.chain.context.ContextInterface;
import org.global.designsoftware.patterns.chain.pipeline.PipelineStep;

@RequiredArgsConstructor
public class LogExecutingTimeStep<TContext extends ContextInterface> implements PipelineStep<TContext> {

    private final PipelineStep<TContext> pipelineStep;

    @Override
    public void execute(TContext context) {
        pipelineStep.introspect();

        long start = System.currentTimeMillis();
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pipelineStep.execute(context);
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения " + pipelineStep.getClass().getSimpleName() + ": " + (end - start) + " ms");

    }

    @Override
    public void introspect() {

    }
}
