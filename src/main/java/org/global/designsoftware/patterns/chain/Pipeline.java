package org.global.designsoftware.patterns.chain;

import org.global.designsoftware.patterns.chain.context.ContextInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Pipeline<TContext extends ContextInterface> {
    private final List<PipelineStep<TContext>> steps = new LinkedList<>();


    public void execute(TContext context) {
        steps.forEach(pipelineStep -> pipelineStep.execute(context));
    }

    public void addStep(PipelineStep<TContext> pipelineStep) {
        steps.add(pipelineStep);
    }


    public void replaceFirstInstance(Class<? extends PipelineStep<TContext>> typeToReplace, PipelineStep<TContext> newStep) {
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i).getClass().equals(typeToReplace)) {
                steps.set(i, newStep);
                return;
            }
        }
    }


    public void wrapAll(Class<? extends PipelineStep<TContext>> typeToWrap, Function<PipelineStep<TContext>, PipelineStep<TContext>> wrapFunc) {

        for (int i = 0; i < steps.size(); i++) {
            PipelineStep<TContext> step = steps.get(i);
            if (typeToWrap.isAssignableFrom(step.getClass())) {
                steps.set(i, wrapFunc.apply(step));
            }
        }
    }
    public void replaceAll(Class<? extends PipelineStep<TContext>> typeToReplace, PipelineStep<TContext> newStep) {
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i).getClass().equals(typeToReplace)) {
                steps.set(i, newStep);
            }
        }
    }

    // Works
}
