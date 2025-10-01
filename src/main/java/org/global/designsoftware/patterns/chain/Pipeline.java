package org.global.designsoftware.patterns.chain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pipeline<TContext extends ContextInterface> {
    private final List<PipelineStep<TContext>> steps = new LinkedList<>();
    public void execute(TContext context){
        steps.forEach(pipelineStep -> pipelineStep.execute(context));
    }

    public void addStep(PipelineStep<TContext> pipelineStep){
        steps.add(pipelineStep);
    }
}
