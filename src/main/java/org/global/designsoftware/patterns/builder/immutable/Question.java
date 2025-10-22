package org.global.designsoftware.patterns.builder.immutable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Getter
@Setter
@ToString
public final class Question {
    private final String text;
    private final List<Answer> answers;

    public static QuestionBuilder builder() {
        return new QuestionBuilder();
    }


    public static class QuestionBuilder {
        private String text;
        private List<Answer> answers = new ArrayList<>();

        QuestionBuilder() {
        }

        public QuestionBuilder text(String text) {
            if (text == null || text.isBlank()) {
                throw new IllegalArgumentException("Question text cannot be empty");
            }

            this.text = text;
            return this;
        }

        public QuestionBuilder answers(List<Answer> answers) {
            if (answers.isEmpty()) {
                throw new IllegalStateException("Test must contain at least one answer");
            }
            this.answers = answers;
            return this;
        }

        public QuestionBuilder addAnswer(Consumer<Answer.AnswerBuilder> config) {
            Answer.AnswerBuilder builder = Answer.builder();
            config.accept(builder);
            answers.add(builder.build());
            return this;
        }

        public QuestionBuilder configureAnswers(Consumer<AnswersScope> scope) {
            scope.accept(new AnswersScope(this));
            return this;
        }

        public Question build() {
            if (text == null || this.text.isBlank()) {
                throw new IllegalArgumentException("Question text cannot be empty");
            }
            return new Question(this.text, this.answers);
        }

        public String toString() {
            return "Question.QuestionBuilder(text=" + this.text + ", answers=" + this.answers + ")";
        }

    }

    public static class AnswersScope {
        private final QuestionBuilder parent;

        AnswersScope(QuestionBuilder parent) {
            this.parent = parent;
        }

        public AnswersScope answer(String text, boolean correct) {
            parent.addAnswer(a -> a.text(text).correct(correct));
            return this;
        }
    }
}

