package com.example.englishquizapptest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.englishquizapptest.R;
import com.example.englishquizapptest.activity.levels.Level1;
import com.example.englishquizapptest.adapter.LessonsAdapter;
import com.example.englishquizapptest.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lessonsRecycler;
    private LessonsAdapter lessonsAdapter;
    public static String STORAGE_NAME = "LessonsStatuses";
    static List<Lesson> lessonList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button deleteProgressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        sharedPreferences = this.getSharedPreferences(STORAGE_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        deleteProgressBtn = findViewById(R.id.delete_progress);
        deleteProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });


        List<Lesson> lessonList = new ArrayList<>();

        lessonList.add(new Lesson(0, "Animals I", "test_background_of_items", sharedPreferences.getString("lesson1Status", "FAILED"), Level1.class));
        lessonList.add(new Lesson(1, "Pronouns I", "test_background_of_items", sharedPreferences.getString("lesson2Status", "CLOSED"), Level1.class));
        lessonList.add(new Lesson(2, "Animals II", "test_background_of_items", sharedPreferences.getString("lesson3Status", "CLOSED"), Level1.class));

        setLessonRecycler(lessonList);

    }


    private void setLessonRecycler(List<Lesson> lessonList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lessonsRecycler = findViewById(R.id.rv_lessons);
        lessonsRecycler.setLayoutManager((layoutManager));

        lessonsAdapter = new LessonsAdapter(this, lessonList);
        lessonsRecycler.setAdapter(lessonsAdapter);
    }

    @Override
    public void onBackPressed() {
        try {
            finishAffinity();
        } catch (Exception e) {
        }
    }
}