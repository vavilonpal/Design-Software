package org.global.designsoftware.patterns.builder.immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public final class Answer {
    private final String text;
    private final boolean correct;

    public static AnswerBuilder builder() {
        return new AnswerBuilder();
    }


    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        if (text == null || text.isBlank()) {
            errors.add("Answer text cannot be empty ");
        }
        return errors;
    }
    public static class AnswerBuilder {
        private String text;
        private boolean correct;

        AnswerBuilder() {
        }

        public AnswerBuilder text(String text) {
            if (text == null || text.isBlank()) {
                throw new IllegalArgumentException("Answer text cannot be empty");
            }
            this.text = text;
            return this;
        }

        public AnswerBuilder correct(Boolean correct) {
            this.correct = correct;
            return this;
        }

        // High level method
        public AnswerBuilder configure(String text, boolean correct) {
            this.text(text);
            this.correct(correct);
            return this;
        }


        // Auto check correctness
        public AnswerBuilder autoCorrect(String text, String expected) {
            this.text(text);
            this.correct(text != null && text.equalsIgnoreCase(expected));
            return this;
        }
        // Copy other builder config
        public AnswerBuilder copyFrom(AnswerBuilder other) {
            if (other == null) throw new IllegalArgumentException("Source builder cannot be null");
            this.text = other.text;
            this.correct = other.correct;
            return this;
        }

        public Answer build() {
            if (text == null || text.isBlank()) {
                throw new IllegalArgumentException("Answer text cannot be empty");
            }
            return new Answer(this.text, this.correct);
        }

        public String toString() {
            return "Answer.AnswerBuilder(text=" + this.text + ", correct=" + this.correct + ")";
        }
    }
}

