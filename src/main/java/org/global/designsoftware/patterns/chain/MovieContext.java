package org.global.designsoftware.patterns.chain;

import lombok.Getter;
import lombok.Setter;
import org.global.designsoftware.entity.Movie;

@Getter
@Setter
public final class MovieContext implements ContextInterface{
    private Movie movie;

}
