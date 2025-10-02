package org.global.designsoftware.patterns.chain;

import org.global.designsoftware.patterns.chain.context.ContextInterface;

public interface PipelineStep<TContext extends ContextInterface>  {

    void execute(TContext context);
    void introspect();
}
