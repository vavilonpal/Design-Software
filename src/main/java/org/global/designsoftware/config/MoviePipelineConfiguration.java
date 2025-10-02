package org.global.designsoftware.config;


import lombok.RequiredArgsConstructor;
import org.global.designsoftware.patterns.chain.*;
import org.global.designsoftware.patterns.chain.context.ListOfMovieContext;
import org.global.designsoftware.patterns.chain.context.MovieContext;
import org.global.designsoftware.patterns.chain.printSteps.PrintDirectorPipelineStep;
import org.global.designsoftware.patterns.chain.printSteps.PrintGenrePipelineStep;
import org.global.designsoftware.patterns.chain.printSteps.PrintTitlePipelineStep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class MoviePipelineConfiguration {
    private final PrintGenrePipelineStep printGenrePipelineStep;
    private final PrintDirectorPipelineStep printDirectorPipelineStep;
    private final PrintTitlePipelineStep printTitlePipelineStep;

    private final SortByTitleStep sortByTitleStep;
    private final FindFirstElementByTitleSortedListStep firstElementByTitleSortedListStep;
    private final Function<PipelineStep<MovieContext>, PipelineStep<MovieContext>>  wrapStepToLogStepFunction = LogExecutingTimeStep::new;


    @Bean
    public Pipeline<MovieContext> printMovieInfoPipeline(){
        Pipeline<MovieContext> pipeline = new Pipeline<>();

        pipeline.addStep(printTitlePipelineStep);
        pipeline.addStep(printDirectorPipelineStep);
        pipeline.addStep(printGenrePipelineStep);
        pipeline.replaceFirstInstance(PrintTitlePipelineStep.class, printGenrePipelineStep);
        pipeline.wrapAll(PrintTitlePipelineStep.class,  wrapStepToLogStepFunction);
        return  pipeline;
    }

    @Bean
    public Pipeline<ListOfMovieContext> findFirstElementByTitleSortMovieList(){
        Pipeline<ListOfMovieContext> pipeline = new Pipeline<>();
        pipeline.addStep(sortByTitleStep);
        pipeline.addStep(firstElementByTitleSortedListStep);
        return pipeline;
    }


}
