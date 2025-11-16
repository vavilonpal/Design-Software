package org.global.designsoftware.patterns.builder.immutable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public final class Question {
    private final String text;
    private final List<Answer> answers;
    private final String creationLocation;


    public static QuestionBuilder builder() {
        //получем место создания билдера
        StackTraceElement location = Thread.currentThread().getStackTrace()[2];
        return new QuestionBuilder(location);
    }

    public static class QuestionBuilder {
        private String text;
        private List<Answer> answers = new ArrayList<>();
        private final StackTraceElement creationPoint;

        QuestionBuilder(StackTraceElement creationPoint) {
            this.creationPoint = creationPoint;
        }

        public QuestionBuilder answers(List<Answer> answers) {
            this.answers = answers;
            return this;
        }

        public QuestionBuilder basicAddition(int x, int y){
            String text = String.format("%d + %d = ?",x,y);
            this.text(text);
            this.configureAnswers(a ->a
                    .answer(Integer.toString(x+y-1), false)
                    .answer(Integer.toString(x+y), true));
            return this;
        }

        public QuestionBuilder text(String text) {
            this.text = text;
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
            List<String> errors = new ArrayList<>();

            if (text == null || text.isBlank()) {
                errors.add("Question text cannot be empty");
            }

            if (answers.isEmpty()) {
                errors.add("Question must contain at least one answer");
            }

            for (int i = 0; i < answers.size(); i++) {
                Answer answer = answers.get(i);
                List<String> answerErrors = answer.validate();

                for (String answerError : answerErrors) {
                    errors.add("Answer[" + i + "]: " + answerError);
                }
            }

            if (!errors.isEmpty()) {
                String errorMessage = "Errors in Question built at " + creationPoint.getFileName() +
                        ":" + creationPoint.getLineNumber() + "\n - " + String.join("\n - ", errors);
                log.info(errorMessage);
                throw new IllegalStateException(errorMessage);
            }

            return new Question(text, answers, creationPoint.getFileName() + ":" + creationPoint.getLineNumber());
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

