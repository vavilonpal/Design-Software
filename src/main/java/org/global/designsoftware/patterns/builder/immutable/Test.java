package org.global.designsoftware.patterns.builder.immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


@Getter
@Setter
@AllArgsConstructor
@ToString
public final class Test {
    private final String title;
    private final String author;
    private final String difficulty;
    private final List<Question> questions;

    public static TestBuilder builder() {
        return new TestBuilder();
    }

    public static class TestBuilder {
        private String title;
        private String author;
        private String difficulty;
        private final List<Question> questions = new ArrayList<>();


        public TestBuilder title(String title) {
            this.title = title;
            return this;
        }

        public TestBuilder scope(Consumer<TestScope> config) {
            config.accept(new TestScope(this));
            return this;
        }

        public TestBuilder addQuestion(Consumer<Question.QuestionBuilder> config) {
            Question.QuestionBuilder builder = Question.builder();
            config.accept(builder);
            questions.add(builder.build());
            return this;
        }

        public Test build() {
            if (title == null || title.isBlank()) {
                throw  new RuntimeException("Test title cannot be empty");
            }
            if (questions.isEmpty()) {
                throw  new RuntimeException("Test must contain at least one question ");
            }
            return new Test(title, author, difficulty, questions);
        }

        // Scope
        public static class TestScope {
            private final TestBuilder parent;

            public TestScope(TestBuilder parent) {
                this.parent = parent;
            }

            public void setAuthor(String author) {
                parent.author = author;
            }

            public void setDifficulty(String difficulty) {
                parent.difficulty = difficulty;
            }
        }
    }
}