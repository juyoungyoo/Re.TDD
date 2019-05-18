package com.tdd.baseballgame;

import com.tdd.baseballgame.model.Answer;
import com.tdd.baseballgame.model.Numbers;
import com.tdd.baseballgame.model.result.AnswerResult;
import com.tdd.baseballgame.model.result.ResultType;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {

        System.out.println("==========정답을 생성합니다 ==========");
        Answer answer = Answer.of("5,1,3");
        System.out.println(answer.toString());

        Scanner scanner = new Scanner(System.in);
        int turn =1;
        AnswerResult answerResult = null;
        do{
            try{
                System.out.println("==========정답을 물어본다 (숫자는 ,로 구분)==========");
                String input = scanner.nextLine();
                String[] inputStrArr = input.split(",");
                Numbers numbers = Numbers.of(Arrays.stream(inputStrArr).mapToInt(Integer::parseInt).toArray());

                answerResult = answer.ask(numbers);

                System.out.println(":::::Turn: " + turn);
                Map<ResultType, Integer> resultType = answerResult.getResult();
                for(Map.Entry<ResultType, Integer> result : resultType.entrySet()){
                    System.out.println(result.getKey().name() + ":" + result.getValue());
                }

                if(answerResult.isCorrect()){
                    System.out.println("정답입니다!!");
                    break;
                }

                turn++;
            }catch (Exception e){
                System.out.println(e);
            }
        }while (!answerResult.isGameOver());
        System.out.println("Game Over... you lose T_T");
    }
}
