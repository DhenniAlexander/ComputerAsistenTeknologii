package com.example.computerasistenteknologi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kecerdasanLayout extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView ;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD, ansE ;
    Button submitBtn;

    CountDownTimer timer;



    int score = 0;
    int totalQuestion = QuestionAnswerKecermatan.question.length;
    int currentQuesitonIndex = 0;

    CountDownTimer countDownTimer;

    long millisUntilFinished;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecerdasan_layout);
        totalQuestionsTextView = findViewById(R.id.total_question2);
        questionTextView = findViewById(R.id.question);

        ansA = findViewById(R.id.ansA);
        ansB = findViewById(R.id.ansB);
        ansC = findViewById(R.id.ansC);
        ansD = findViewById(R.id.ansD);
        ansE = findViewById(R.id.ansE);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        ansE.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();

    }


    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionsAnswerKecerdasan.correctAnswers[currentQuesitonIndex])){
                score++;
            }
            currentQuesitonIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }



    }
    void loadNewQuestion () {
        if (currentQuesitonIndex == totalQuestion){
            finishQuiz();
            return;
        }



        questionTextView.setText(QuestionsAnswerKecerdasan.question[currentQuesitonIndex]);
        ansA.setText(QuestionsAnswerKecerdasan.choices[currentQuesitonIndex][0]);
        ansB.setText(QuestionsAnswerKecerdasan.choices[currentQuesitonIndex][1]);
        ansC.setText(QuestionsAnswerKecerdasan.choices[currentQuesitonIndex][2]);
        ansD.setText(QuestionsAnswerKecerdasan.choices[currentQuesitonIndex][3]);
        ansE.setText(QuestionsAnswerKecerdasan.choices[currentQuesitonIndex][4]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Your Score";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuesitonIndex =0;
        loadNewQuestion();
    }

    public void backbtn(View view) {
        startActivity(new Intent(getApplicationContext(), MainMenu.class));

    }
}