package org.global.designsoftware.patterns.chain;

import org.springframework.stereotype.Component;

@Component
public class PrintTitlePipelineStep implements PipelineStep<MovieContext> {
    @Override
    public void execute(MovieContext movieContext) {
        System.out.println("Title: " + movieContext.getMovie().getTitle());
    }

    @Override
    public void Introspect() {

    }
}
