package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Question;

public class QuestionGenerator {
    final String[] easyOptions = {"+", "-"};
    final String[] mediumOptions = {"+", "-", "*"};
    final String[] hardOptions = {"+", "-", "*"};

    public Question generateQuestion (String difficulty, Question questionInstance) {
        if("EASY".equals(difficulty)) {
            questionInstance = makeEasyQuestion(questionInstance);
        }
        else if ("MEDIUM".equals(difficulty)) {
            questionInstance = makeMediumQuestion(questionInstance);
        }
        else if ("HARD".equals(difficulty)) {
            questionInstance = makeHardQuestion(questionInstance);
        }
        return questionInstance;
    }

    public Question makeEasyQuestion(Question question) {
        //choosing Math operation
        Random randomOperation = new Random();
        int easyIndex = randomOperation.nextInt(easyOptions.length);
        String randomOperationChosen = easyOptions[easyIndex];

        //making an equation
        String firstNumber = createRandomNumber(-9, 9);
        String secondNumber = createRandomNumber(-9, 9);
        String quest = firstNumber + randomOperationChosen + secondNumber;

        //calculating correct answer
        double correctAnswer = eval(quest);
        int correctAnswerInInt = (int) correctAnswer;

        String correctAnswerInString = String.valueOf(correctAnswerInInt);

        //calculating wrongAnswer1 - an opposite answer
        String oppositeOperation = oppositeOperation(randomOperationChosen);
        String oppositeQuestion = firstNumber + oppositeOperation + secondNumber;
        double wrongAnswer = eval(oppositeQuestion);
        int wrongAnswer1InInt = (int) wrongAnswer;
        String wrongAnswer1InString = String.valueOf(wrongAnswer1InInt);

        //calculating wrongAnswer2 - increase result by 1
        int wrongAnswer2InInt = correctAnswerInInt + 1;
        String wrongAnswer2InString = String.valueOf(wrongAnswer2InInt);

        //calculating wrongAnswer3 - decrease result by 1
        int wrongAnswer3InInt = correctAnswerInInt - 1;
        String wrongAnswer3InString = String.valueOf(wrongAnswer3InInt);

        //shuffleAnswers
        String[] answerOptions = {correctAnswerInString, wrongAnswer1InString, wrongAnswer2InString, wrongAnswer3InString};
        answerOptions = shuffleAnswers(answerOptions);

        /*List<String> strList = Arrays.asList(answerOptions);
        Collections.shuffle(strList);
        answerOptions = strList.toArray(new String[strList.size()]);*/

        //set answers
        question.setAnswer1(answerOptions[0]);
        question.setAnswer2(answerOptions[1]);
        question.setAnswer3(answerOptions[2]);
        question.setAnswer4(answerOptions[3]);
        question.setCorrectAnswer(correctAnswerInString);
        question.setCalculation(quest);

        return question;
    }

    public Question makeMediumQuestion(Question question) {
        //choosing Math operation
        Random randomOperation = new Random();
        int easyIndex = randomOperation.nextInt(mediumOptions.length);
        String randomOperationChosen = mediumOptions[easyIndex];

        //making an equation
        String firstNumber = createRandomNumber(-19, 19);
        String secondNumber = createRandomNumber(-19, 19);
        String quest = firstNumber + randomOperationChosen + secondNumber;

        //calculating correct answer
        double correctAnswer = eval(quest);
        int correctAnswerInInt = (int) correctAnswer;
        String correctAnswerInString = String.valueOf(correctAnswerInInt);

        //calculating wrongAnswer1 - an opposite answer
        String oppositeOperation = oppositeOperation(randomOperationChosen);
        String oppositeQuestion = firstNumber + oppositeOperation + secondNumber;
        double wrongAnswer = eval(oppositeQuestion);
        int wrongAnswer1InInt = (int) wrongAnswer;
        String wrongAnswer1InString = String.valueOf(wrongAnswer1InInt);

        //calculating wrongAnswer2 - increase result by 1
        int wrongAnswer2InInt = correctAnswerInInt + 1;
        String wrongAnswer2InString = String.valueOf(wrongAnswer2InInt);

        //calculating wrongAnswer3 - decrease result by 1
        int wrongAnswer3InInt = correctAnswerInInt - 1;
        String wrongAnswer3InString = String.valueOf(wrongAnswer3InInt);

        //shuffleAnswers
        String[] answerOptions = {correctAnswerInString, wrongAnswer1InString, wrongAnswer2InString, wrongAnswer3InString};
        answerOptions = shuffleAnswers(answerOptions);

        /*
        List<String> strList = Arrays.asList(answerOptions);
        Collections.shuffle(strList);
        answerOptions = strList.toArray(new String[strList.size()]);
*/
        //set answers
        question.setAnswer1(answerOptions[0]);
        question.setAnswer2(answerOptions[1]);
        question.setAnswer3(answerOptions[2]);
        question.setAnswer4(answerOptions[3]);
        question.setCorrectAnswer(correctAnswerInString);
        question.setCalculation(quest);

        return question;
    }

    public Question makeHardQuestion(Question question) {
        //choosing Math operation
        Random randomOperation = new Random();
        int easyIndex1 = randomOperation.nextInt(hardOptions.length);
        int easyIndex2 = randomOperation.nextInt(hardOptions.length);
        String randomOperationChosen1 = hardOptions[easyIndex1];
        String randomOperationChosen2 = hardOptions[easyIndex2];

        //making an equation
        String firstNumber = createRandomNumber(-19, 19);
        String secondNumber = createRandomNumber(-19, 19);
        String thirdNumber = createRandomNumber(-19, 19);

        String quest = firstNumber + randomOperationChosen1 + secondNumber + randomOperationChosen2 + thirdNumber;

        //calculating correct answer
        double correctAnswer = eval(quest);
        int correctAnswerInInt = (int) correctAnswer;
        String correctAnswerInString = String.valueOf(correctAnswerInInt);

        //calculating wrongAnswer1 - an opposite answer
        String oppositeOperation1 = oppositeOperation(randomOperationChosen1);
        String oppositeOperation2 = oppositeOperation(randomOperationChosen2);
        String oppositeQuestion = firstNumber + oppositeOperation1 + secondNumber + oppositeOperation2 + thirdNumber;
        double wrongAnswer = eval(oppositeQuestion);
        int wrongAnswer1InInt = (int) wrongAnswer;
        String wrongAnswer1InString = String.valueOf(wrongAnswer1InInt);

        //calculating wrongAnswer2 - increase result by 1
        int wrongAnswer2InInt = correctAnswerInInt + 1;
        String wrongAnswer2InString = String.valueOf(wrongAnswer2InInt);

        //calculating wrongAnswer3 - decrease result by 1
        int wrongAnswer3InInt = correctAnswerInInt - 1;
        String wrongAnswer3InString = String.valueOf(wrongAnswer3InInt);

        //shuffleAnswers
        String[] answerOptions = {correctAnswerInString, wrongAnswer1InString, wrongAnswer2InString, wrongAnswer3InString};
        answerOptions = shuffleAnswers(answerOptions);

        /*List<String> strList = Arrays.asList(answerOptions);
        Collections.shuffle(strList);
        answerOptions = strList.toArray(new String[strList.size()]);*/

        //set answers
        question.setAnswer1(answerOptions[0]);
        question.setAnswer2(answerOptions[1]);
        question.setAnswer3(answerOptions[2]);
        question.setAnswer4(answerOptions[3]);
        question.setCorrectAnswer(correctAnswerInString);
        question.setCalculation(quest);

        return question;
    }

    public String[] shuffleAnswers(String[] answers) {
        //shuffle answers
        List<String> strList = Arrays.asList(answers);
        Collections.shuffle(strList);
        answers = strList.toArray(new String[strList.size()]);

        return answers;
    }

    public Question doTheMathFull (String quest, Question question) {
        double correctAnswer = eval(quest);
        int correctAnswerInInt = (int) correctAnswer;
        question.setCorrectAnswer(String.valueOf(correctAnswerInInt));
        question.setAnswer1("1");
        question.setAnswer2("2");
        question.setAnswer3("3");
        question.setAnswer4(String.valueOf(correctAnswerInInt));
        return question;
    }

    public String createRandomNumber (int minNum, int maxNum) {
        Random r = new Random();
        int result = r.nextInt(maxNum-minNum+1)+minNum;
        if (result<0){
            return "(" + result + ")";
        } else {
            return String.valueOf(result);
        }
    }

    public String oppositeOperation(String s) {
        if("+".equals(s)){ return "-"; }
        else if ("-".equals(s)){ return "*"; }
        else { return "+"; }
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
