package org.global.designsoftware.patterns.builder;


import org.global.designsoftware.patterns.builder.immutable.Answer;
import org.global.designsoftware.patterns.builder.immutable.Question;
import org.global.designsoftware.patterns.builder.immutable.Test;

public class Main {
    public static void main(String[] args) {
        Answer answer = Answer.builder()
                .text("fgfg")
                .correct(true)
                .build();


        Test test = Test.builder()
                .title("Basic Math")
                .scope(s -> {
                    s.setAuthor("John Doe");
                    s.setDifficulty("Easy");
                })
                .addQuestion(q -> q
                        .text("2 + 2 = ?")
                        .configureAnswers(a -> a
                                .answer("3", false)
                                .answer("4", true)
                        )
                )
                .addQuestion(q -> q
                        .text("5 + 5 = ?")
                        .configureAnswers(a -> a
                                .answer("10", true)
                        )
                )
                .build();

        System.out.println(test);
    }


}
