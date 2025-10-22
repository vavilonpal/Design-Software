package org.global.designsoftware.patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public final class Answer {
    private final String text;
    private final boolean correct;
}

