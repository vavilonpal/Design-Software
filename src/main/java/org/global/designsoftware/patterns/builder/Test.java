package org.global.designsoftware.patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@ToString
public final class Test {
    private final String title;
    private final List<Question> questions;
}
