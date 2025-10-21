package org.global.designsoftware.patterns.chain.pipeline;

import org.global.designsoftware.patterns.chain.context.ContextInterface;

public interface PipelineStep<TContext extends ContextInterface>  {

    void execute(TContext context);
    void introspect();
}
