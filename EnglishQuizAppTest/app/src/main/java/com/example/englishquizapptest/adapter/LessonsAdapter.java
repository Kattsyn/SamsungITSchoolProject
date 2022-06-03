package com.example.englishquizapptest.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishquizapptest.R;
import com.example.englishquizapptest.activity.levels.Level1;
import com.example.englishquizapptest.model.Lesson;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonViewHolder> {

    List<Lesson> lessons;
    Context context;

    public LessonsAdapter(Context context, List<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.lesson_list_layout;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);

        LessonViewHolder viewHolder = new LessonViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.lessonTitle.setText(lessons.get(position).getTitle());

        int imageId = context.getResources().getIdentifier("test_background_of_items" + lessons.get(position).getBackground(), "drawable-v24", context.getPackageName());
        String imageName = "test_background_of_items" + String.valueOf(position + 1);
        int resID = holder.lessonBg.getContext().getResources().getIdentifier(imageName, "drawable", holder.lessonBg.getContext().getPackageName());
        holder.lessonBg.setImageResource(resID);
        if (lessons.get(position).getStatus().equals("FINISHED")) {
            holder.lessonStatus.setText(R.string.lesson_completed);
            holder.lessonStatus.setTextColor(context.getResources().getColor(R.color.btnCorrect));
            holder.itemView.setEnabled(true);
        } else if (lessons.get(position).getStatus().equals("FAILED")) {
            holder.lessonStatus.setText(R.string.lesson_not_completed);
            holder.lessonStatus.setTextColor(context.getResources().getColor(R.color.btnWrong));
            holder.itemView.setEnabled(true);
        } else {
            holder.lessonStatus.setText(R.string.lesson_closed);
            holder.lessonStatus.setTextColor(context.getResources().getColor(R.color.lessonClosed));
            holder.itemView.setEnabled(false);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, lessons.get(position).getLessonClass());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder {

        TextView lessonTitle;
        ImageView lessonBg;
        TextView lessonStatus;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonTitle = itemView.findViewById(R.id.lesson_title);
            lessonBg = itemView.findViewById(R.id.lesson_bg);
            lessonStatus = itemView.findViewById(R.id.lesson_status);

        }

        void bind() {
        }
    }
}
