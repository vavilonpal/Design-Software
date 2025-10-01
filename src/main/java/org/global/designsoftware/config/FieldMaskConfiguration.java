package org.global.designsoftware.config;

import org.global.designsoftware.patterns.MovieFieldMask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FieldMaskConfiguration {

    @Bean
    public MovieFieldMask titleEqualsMask(){
        return MovieFieldMask.builder()
                .title(true)
                .build();
    }
    @Bean
    public MovieFieldMask copyMaskByDirectorAndFees(){
        return MovieFieldMask.builder()
                .director(true)
                .fees(true)
                .build();
    }
    @Bean
    public MovieFieldMask directorAndGenre(){
        return MovieFieldMask.builder()
                .director(true)
                .genre(true)
                .build();
    }
}
