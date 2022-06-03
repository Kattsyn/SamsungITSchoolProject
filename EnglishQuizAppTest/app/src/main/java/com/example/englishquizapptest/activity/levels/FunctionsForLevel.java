package com.example.englishquizapptest.activity.levels;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.englishquizapptest.R;

import java.util.Random;

public class FunctionsForLevel {

    public void nextExercise(Button[] btnList, Button btnNext, ImageView currLvlImg, int newImg, int correctAnswer, int[] wrongAnswersList) {
        Random random = new Random();
        int randomNum1 = random.nextInt(4);
        int randomNum2 = random.nextInt(4);
        while (randomNum1 == randomNum2) {
            randomNum2 = random.nextInt(4);
        }
        int randomNum3 = random.nextInt(4);
        while (randomNum3 == randomNum1 || randomNum3 == randomNum2) {
            randomNum3 = random.nextInt(4);
        }
        int randomNum4 = random.nextInt(4);
        while (randomNum4 == randomNum1 || randomNum4 == randomNum2 || randomNum4 == randomNum3) {
            randomNum4 = random.nextInt(4);
        }
        btnList[randomNum1].setText(correctAnswer);
        btnList[randomNum2].setText(wrongAnswersList[0]);
        btnList[randomNum3].setText(wrongAnswersList[1]);
        btnList[randomNum4].setText(wrongAnswersList[2]);
        currLvlImg.setImageResource(newImg);

        btnList[0].setBackgroundResource(R.drawable.style_btn_answer);
        btnList[1].setBackgroundResource(R.drawable.style_btn_answer);
        btnList[2].setBackgroundResource(R.drawable.style_btn_answer);
        btnList[3].setBackgroundResource(R.drawable.style_btn_answer);

        btnList[0].setEnabled(true);
        btnList[1].setEnabled(true);
        btnList[2].setEnabled(true);
        btnList[3].setEnabled(true);
        btnNext.setEnabled(false);
    }
}
