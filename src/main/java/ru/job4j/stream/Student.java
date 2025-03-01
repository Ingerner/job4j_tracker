package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String surname;

    public Student(int scope, String surname) {
        this.score = scope;
        this.surname = surname;
    }

    public Student(String surname, int scope) {
        this.score = scope;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}
