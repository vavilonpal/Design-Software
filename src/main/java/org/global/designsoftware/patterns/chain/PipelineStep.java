package org.global.designsoftware.patterns.chain;

public interface PipelineStep {

    void execute(Context context);
    void Introspect();
}
