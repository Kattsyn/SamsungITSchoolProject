package com.example.englishquizapptest.model;

public class Lesson {

    int id;
    String title, background, status;


    Class lessonClass;

    public Lesson(int id, String title, String background,String status, Class lessonClass) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.background = background;
        this.lessonClass = lessonClass;
    }

    public Class getLessonClass() {
        return lessonClass;
    }

    public void setClassName(Class lessonClass) {
        this.lessonClass = lessonClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }


}
