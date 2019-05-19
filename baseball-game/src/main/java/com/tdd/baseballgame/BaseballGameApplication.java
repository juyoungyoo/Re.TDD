package com.tdd.baseballgame;

import com.tdd.baseballgame.io.InputConsole;
import com.tdd.baseballgame.io.OutputConsole;
import com.tdd.baseballgame.model.BaseballGame;
import com.tdd.baseballgame.model.Numbers;
import com.tdd.baseballgame.model.result.AnswerResult;

public class BaseballGameApplication {
    public static void main(String[] args) {

        String inputAnswer = InputConsole.writeAnswer();
        BaseballGame baseballGame = new BaseballGame(Numbers.of(inputAnswer));
        OutputConsole.answer(baseballGame);

        while (true)
            try {
                String inputExceptNumbers = InputConsole.ask();
                Numbers expectedNumbers = Numbers.of(inputExceptNumbers);
                AnswerResult answerResult = baseballGame.ask(expectedNumbers);
                OutputConsole.result(answerResult);

                if (answerResult.isCorrect()) {
                    OutputConsole.summary(baseballGame, "정답입니다!!");
                    break;
                } else if (answerResult.isGameOver()) {
                    OutputConsole.summary(baseballGame, "Game Over... you lose T_T");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}
