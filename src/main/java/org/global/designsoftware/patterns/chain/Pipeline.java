package org.global.designsoftware.patterns.chain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pipeline {
    private final List<PipelineStep> steps = new LinkedList<>();
    public void execute(Context context){
        steps.forEach(pipelineStep -> pipelineStep.execute(context));
    }

    public void addStep(PipelineStep pipelineStep){
        steps.add(pipelineStep);
    }
}
