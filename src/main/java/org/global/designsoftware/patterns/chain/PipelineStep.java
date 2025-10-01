package org.global.designsoftware.patterns.chain;

public interface PipelineStep<TContext extends ContextInterface>  {

    void execute(TContext context);
    void Introspect();
}
