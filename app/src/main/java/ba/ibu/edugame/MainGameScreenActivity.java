package ba.ibu.edugame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import logic.QuestionGenerator;
import model.Question;

public class MainGameScreenActivity extends AppCompatActivity {

    public static final String QUESTIONS_ASKED = "edugame.QUESTIONS_ASKED";
    public static final String CORRECT_ANSWERS = "edugame.CORRECT_ANSWERS";
    public static final String WRONG_ANSWERS = "edugame.WRONG_ANSWERS";
    public static final String RESULTS = "edugame.RESULTS";

    private String difficulty;
    private String gameTimeText;
    private String gameTimeInSeconds;
    private TextView txtTimeInSeconds;
    private int time;
    private CountDownTimer cTimer;

    QuestionGenerator questionGenerator = new QuestionGenerator();
    Question questionInstance = new Question();

    int numberOfQuestions = 0;
    int numberOfCorrectAnswers = 0;
    int numberOfWrongAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //Hide action bar on top
        setContentView(R.layout.activity_main_game_screen);

        //Get chosen level, game time, game time in seconds strings
        Intent intent = getIntent();
        difficulty = intent.getStringExtra(GameModeActivity.GAME_DIFFICULTY);
        gameTimeText = intent.getStringExtra(GameModeActivity.GAME_MODE_TEXT);
        gameTimeInSeconds = intent.getStringExtra(GameModeActivity.GAME_MODE);

        //Set text view to chosen level
        TextView txtLevelDifficulty = findViewById(R.id.txtDifficulty);
        txtLevelDifficulty.setText(difficulty);

        //Set text view to chosen time
        TextView txtGameTimeText = findViewById(R.id.txtTime);
        txtGameTimeText.setText(gameTimeText);

        //Set text view to chosen time for countdown
        txtTimeInSeconds = findViewById(R.id.txtTimeInSeconds);
        txtTimeInSeconds.setText(gameTimeInSeconds);

        startTimer(Integer.parseInt(gameTimeInSeconds));

        //Set initial question and answers
        questionInstance = questionGenerator.generateQuestion(difficulty, questionInstance);
        TextView txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestion.setText(questionInstance.getCalculation());

        TextView choiceButton1 = findViewById(R.id.btnAnswer1);
        TextView choiceButton2 = findViewById(R.id.btnAnswer2);
        TextView choiceButton3 = findViewById(R.id.btnAnswer3);
        TextView choiceButton4 = findViewById(R.id.btnAnswer4);

        choiceButton1.setText(questionInstance.getAnswer1());
        choiceButton2.setText(questionInstance.getAnswer2());
        choiceButton3.setText(questionInstance.getAnswer3());
        choiceButton4.setText(questionInstance.getAnswer4());
    }


    void startTimer(int time) {
        cTimer = new CountDownTimer(time * 1000, 100) {
            public void onTick(long millisUntilFinished) {
                double d = (double) millisUntilFinished / 1000;
                txtTimeInSeconds.setText((String.format("%.1f", d)));
            }

            public void onFinish() {
                double d = 0.0;
                txtTimeInSeconds.setText((String.format("%.1f", d)));
                Intent i = new Intent(MainGameScreenActivity.this, FinishedGameActivity.class);
                i.putExtra(QUESTIONS_ASKED, numberOfQuestions);
                i.putExtra(CORRECT_ANSWERS, numberOfCorrectAnswers);
                i.putExtra(WRONG_ANSWERS, numberOfWrongAnswers);
                i.putExtra(RESULTS, finalResult());
                startActivity(i);
                finish();
            }
        };
        cTimer.start();
    }

    void cancelTimer() {
        if(cTimer != null) {
            cTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainGameScreenActivity.this, "You quit the game!", Toast.LENGTH_SHORT).show();
        cancelTimer();
        finish();
        super.onBackPressed();
    }

    public void sumbitAnswer(View view) {
        String givenAnswer = String.valueOf(((TextView) view).getText());
        String correctAnswer  = questionInstance.getCorrectAnswer();
        checkAnswer(givenAnswer, correctAnswer);
        createNewQuestion();
    }

    public void checkAnswer(String givenAnswer, String correctAnswer) {
        if(givenAnswer.equals(correctAnswer)) {
            numberOfCorrectAnswers++;
        }
        else {
            numberOfWrongAnswers++;
        }
        numberOfQuestions++;
    }

    public void createNewQuestion() {
        Question newQuestion = new Question();
        questionInstance = questionGenerator.generateQuestion(difficulty, newQuestion);

        TextView txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestion.setText(questionInstance.getCalculation());

        TextView choiceButton1 = findViewById(R.id.btnAnswer1);
        TextView choiceButton2 = findViewById(R.id.btnAnswer2);
        TextView choiceButton3 = findViewById(R.id.btnAnswer3);
        TextView choiceButton4 = findViewById(R.id.btnAnswer4);

        choiceButton1.setText(questionInstance.getAnswer1());
        choiceButton2.setText(questionInstance.getAnswer2());
        choiceButton3.setText(questionInstance.getAnswer3());
        choiceButton4.setText(questionInstance.getAnswer4());
    }

    public String finalResult() {
        double result = numberOfCorrectAnswers/numberOfQuestions;
        String s = Double.toString(result);
        return s;
    }

}