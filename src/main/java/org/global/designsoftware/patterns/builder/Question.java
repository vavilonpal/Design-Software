package org.global.designsoftware.patterns.builder;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public final class Question {
    private final String text;
    private final List<Answer> answers;
}

