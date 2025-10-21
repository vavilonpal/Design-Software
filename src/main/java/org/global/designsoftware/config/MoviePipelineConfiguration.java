package org.global.designsoftware.config;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.patterns.chain.*;
import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;
import org.global.designsoftware.patterns.chain.context.MovieContext;
import org.global.designsoftware.patterns.chain.pipeline.Pipeline;
import org.global.designsoftware.patterns.chain.pipeline.PipelineStep;
import org.global.designsoftware.patterns.chain.printSteps.PrintDirectorPipelineStep;
import org.global.designsoftware.patterns.chain.printSteps.PrintGenrePipelineStep;
import org.global.designsoftware.patterns.chain.printSteps.PrintTitlePipelineStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class MoviePipelineConfiguration {

    /***
     * Используйте generics чтобы задавать тип контекста извне.
     * Сделайте Pipeline и IPipelineStep зависимыми от типа контекста (то есть, Pipeline<TContext> и IPipelineStep<TContext>).
     *
     * Используйте паттерн Декоратор, чтобы создать хотя бы 2 PipelineStep-а, которые подойдут вашей тематике.
     * Выполняйте код до, после или и до и после шага, сохраненном в них.
     *
     * Сделайте как минимум 3 высокоуровневых методов для изменения действий в массиве.
     *
     * Используйте паттерн Singleton для того, чтобы избежать повторного создания PipelineStep
     */

    private final PrintGenrePipelineStep printGenrePipelineStep;
    private final PrintDirectorPipelineStep printDirectorPipelineStep;
    private final PrintTitlePipelineStep printTitlePipelineStep;

    private final SortByTitleStep sortByTitleStep;
    private final FindFirstElementByTitleSortedListStep firstElementByTitleSortedListStep;
    private final Function<PipelineStep<MovieContext>, PipelineStep<MovieContext>> wrapStepToLogStepFunction = LogExecutingTimeStep::new;


    @Bean
    public Pipeline<MovieContext> printMovieInfoPipeline() {
        Pipeline<MovieContext> pipeline = new Pipeline<>();

        pipeline.addStep(printTitlePipelineStep);
        pipeline.addStep(printDirectorPipelineStep);
        pipeline.addStep(printGenrePipelineStep);
        pipeline.replaceFirstInstance(PrintTitlePipelineStep.class, printGenrePipelineStep);
        pipeline.wrapAll(PrintTitlePipelineStep.class, wrapStepToLogStepFunction);
        return pipeline;
    }

    @Bean
    public Pipeline<ListOfMovieContext> findFirstElementByTitleSortMovieList() {
        Pipeline<ListOfMovieContext> pipeline = new Pipeline<>();
        pipeline.addStep(sortByTitleStep);
        pipeline.addStep(firstElementByTitleSortedListStep);
        return pipeline;
    }


}
