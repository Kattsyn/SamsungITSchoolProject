package com.example.englishquizapptest.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.englishquizapptest.R;
import com.example.englishquizapptest.activity.levels.ArraysForLevels;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    Button btnNext;
    int correctAnswers;
    int idOfLesson;
    TextView textResult;
    TextView textResultPercentage;
    ImageView imgResult;
    ArraysForLevels arrays = new ArraysForLevels();
    Random random;
    String status;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_result);
        btnNext = (Button) findViewById(R.id.result_button_next);
        textResult = (TextView) findViewById(R.id.text_result);
        textResultPercentage = (TextView) findViewById(R.id.text_result_percentage);
        imgResult = (ImageView) findViewById(R.id.result_image);
        random = new Random();
        correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        idOfLesson = getIntent().getIntExtra("idOfLesson", 0);
        String thisLesson = "lesson" + Integer.toString(idOfLesson) + "Status";
        String nextLesson = "lesson" + Integer.toString(idOfLesson + 1) + "Status";


        if (correctAnswers >= 8) {
            textResultPercentage.setText(Integer.toString(correctAnswers * 10) + "%");
            textResultPercentage.setTextColor(getResources().getColor(R.color.btnCorrect));
            textResult.setText(R.string.level_succeeded);
            imgResult.setImageResource(arrays.resultImgsSuccess[random.nextInt(arrays.resultImgsSuccess.length)]);

            SharedPreferences sharedPreferences = this.getSharedPreferences(MainActivity.STORAGE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(thisLesson, "FINISHED");
            editor.putString(nextLesson, "FAILED");
            editor.apply();
        } else {
            textResultPercentage.setText(Integer.toString(correctAnswers * 10) + "%");
            textResultPercentage.setTextColor(getResources().getColor(R.color.btnWrong));
            textResult.setText(R.string.level_failed);
            imgResult.setImageResource(arrays.resultImgsFail[random.nextInt(arrays.resultImgsFail.length)]);
            status = "FAILED";
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                ResultActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}
