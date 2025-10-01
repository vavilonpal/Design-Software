package org.global.designsoftware.config;


import org.global.designsoftware.patterns.chain.Pipeline;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoviePipelineConfiguration {

    @Bean
    public Pipeline logInfoPipeline(){
        Pipeline pipeline = new Pipeline();

    }

}
