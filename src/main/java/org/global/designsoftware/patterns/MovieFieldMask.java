package org.global.designsoftware.patterns;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieFieldMask {
    private boolean id;
    private boolean title;
    private boolean director;
    private boolean fees;
    private boolean genre;
}