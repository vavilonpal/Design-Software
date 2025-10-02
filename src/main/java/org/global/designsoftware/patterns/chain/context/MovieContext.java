package org.global.designsoftware.patterns.chain.context;

import lombok.Getter;
import lombok.Setter;
import org.global.designsoftware.entity.Movie;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public final class MovieContext implements ContextInterface {
    private Movie movie;

}
