package com.example.englishquizapptest.activity.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.englishquizapptest.R;
import com.example.englishquizapptest.activity.MainActivity;
import com.example.englishquizapptest.activity.ResultActivity;


import java.util.Objects;

public class Level2 extends AppCompatActivity {

    ImageView lvlImg;
    TextView levelText;
    int exerciseNum;
    ArraysForLevels arrays = new ArraysForLevels();
    Button[] btnList = new Button[4];
    TextView[] ptsList = new TextView[10];
    int correctAnswers = 0;
    int incorrectAnswers = 0;
    FunctionsForLevel functions = new FunctionsForLevel();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.lesson_sample);
        Animation btnAnim = AnimationUtils.loadAnimation(Level2.this, R.anim.button_anim);
        exerciseNum = 0;
        ImageView lvlImg = (ImageView) findViewById(R.id.level_img);
        TextView levelText = findViewById(R.id.text_lesson);
        btnList[0] = (Button) findViewById(R.id.button_top_left);
        btnList[1] = (Button) findViewById(R.id.button_top_right);
        btnList[2] = (Button) findViewById(R.id.button_bottom_left);
        btnList[3] = (Button) findViewById(R.id.button_bottom_right);
        Button btnBack = (Button) findViewById(R.id.button_back);
        Button btnNext = (Button) findViewById(R.id.button_next);
        btnNext.setEnabled(false);

        ptsList[0] = (TextView) findViewById(R.id.point1);
        ptsList[1] = (TextView) findViewById(R.id.point2);
        ptsList[2] = (TextView) findViewById(R.id.point3);
        ptsList[3] = (TextView) findViewById(R.id.point4);
        ptsList[4] = (TextView) findViewById(R.id.point5);
        ptsList[5] = (TextView) findViewById(R.id.point6);
        ptsList[6] = (TextView) findViewById(R.id.point7);
        ptsList[7] = (TextView) findViewById(R.id.point8);
        ptsList[8] = (TextView) findViewById(R.id.point9);
        ptsList[9] = (TextView) findViewById(R.id.point10);


        levelText.setText(R.string.lesson1);
        lvlImg.setClipToOutline(true);

        btnList[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnList[0].startAnimation(btnAnim);
                btnList[1].setEnabled(false);
                btnList[2].setEnabled(false);
                btnList[3].setEnabled(false);
                btnNext.setEnabled(true);
                if (btnList[0].getText() == getText(arrays.correctAnswersLevel1[exerciseNum])) {
                    correctAnswers++;
                    btnList[0].setBackgroundResource(R.drawable.style_btn_answer_correct);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_correct);
                } else {
                    incorrectAnswers++;
                    btnList[0].setBackgroundResource(R.drawable.style_btn_answer_wrong);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_wrong);
                }
            }
        });

        btnList[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnList[1].startAnimation(btnAnim);
                btnList[0].setEnabled(false);
                btnList[2].setEnabled(false);
                btnList[3].setEnabled(false);
                btnNext.setEnabled(true);
                if (btnList[1].getText() == getText(arrays.correctAnswersLevel1[exerciseNum])) {
                    correctAnswers++;
                    btnList[1].setBackgroundResource(R.drawable.style_btn_answer_correct);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_correct);
                } else {
                    incorrectAnswers++;
                    btnList[1].setBackgroundResource(R.drawable.style_btn_answer_wrong);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_wrong);
                }
            }
        });

        btnList[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnList[2].startAnimation(btnAnim);
                btnList[0].setEnabled(false);
                btnList[1].setEnabled(false);
                btnList[3].setEnabled(false);
                btnNext.setEnabled(true);
                if (btnList[2].getText() == getText(arrays.correctAnswersLevel1[exerciseNum])) {
                    correctAnswers++;
                    btnList[2].setBackgroundResource(R.drawable.style_btn_answer_correct);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_correct);
                } else {
                    incorrectAnswers++;
                    btnList[2].setBackgroundResource(R.drawable.style_btn_answer_wrong);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_wrong);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_wrong);
                }
            }
        });

        btnList[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnList[3].startAnimation(btnAnim);
                btnList[0].setEnabled(false);
                btnList[1].setEnabled(false);
                btnList[2].setEnabled(false);
                btnNext.setEnabled(true);
                if (btnList[3].getText() == getText(arrays.correctAnswersLevel1[exerciseNum])) {
                    correctAnswers++;
                    btnList[3].setBackgroundResource(R.drawable.style_btn_answer_correct);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_correct);
                } else {
                    incorrectAnswers++;
                    btnList[3].setBackgroundResource(R.drawable.style_btn_answer_wrong);
                    ptsList[exerciseNum].setBackgroundResource(R.drawable.style_points_wrong);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level2.this, MainActivity.class);
                    Level2.this.startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exerciseNum++;
                if (exerciseNum == 10) {
                    Intent intent = new Intent(Level2.this, ResultActivity.class);
                    intent.putExtra("correctAnswers", correctAnswers);
                    intent.putExtra("idOfLesson", 1);
                    Level2.this.startActivity(intent);
                    finish();
                } else {
                    functions.nextExercise(btnList, btnNext, lvlImg, arrays.imgsForExercisesLevel2[exerciseNum],
                            arrays.correctAnswersLevel2[exerciseNum], arrays.wrongAnswersLevel2[exerciseNum]);
                }
            }
        });

        //functions.nextExercise(btnList, btnNext, lvlImg, R.drawable.exerciseimgtest400400,
        //        arrays.correctAnswersLevel2[exerciseNum], arrays.wrongAnswersLevel2[exerciseNum]);


    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level2.this, MainActivity.class);
            Level2.this.startActivity(intent);
            finish();
        } catch (Exception e) {
        }
    }

}
