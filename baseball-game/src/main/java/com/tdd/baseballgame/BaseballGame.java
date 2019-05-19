package com.tdd.baseballgame;

import com.tdd.baseballgame.io.InputConsole;
import com.tdd.baseballgame.io.OutputConsole;
import com.tdd.baseballgame.model.Answer;
import com.tdd.baseballgame.model.Numbers;
import com.tdd.baseballgame.model.result.AnswerResult;

public class BaseballGame {
    public static void main(String[] args) {

        String inputAnswer = InputConsole.writeAnswer();
        Answer correctAnswer = Answer.of(inputAnswer);
        OutputConsole.answer(correctAnswer);

        AnswerResult answerResult = null;
        do {
            try {
                String expectedNumbers = InputConsole.ask();
                Numbers numbers = Answer.of(expectedNumbers).getNumbers();
                answerResult = correctAnswer.ask(numbers);

                OutputConsole.result(answerResult);

                if (answerResult.isCorrect()) {
                    System.out.println("정답입니다!!");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!answerResult.isGameOver());

        if(answerResult.isGameOver()){
            System.out.println("Game Over... you lose T_T");
        }
    }
}
