package ru.job4j.map;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeByMap {
    //*вычисляет общий средний балл*/
    public static double averageScore(List<Pupil> pupils) {
        List<Subject> listSubject = new ArrayList<>();
        double sumStudnts = 0;
        double sumAvg = 0;
        double sumSt = 0;
        int k = 0;
        double avg = 0;
        for (int i = 0; i < pupils.size(); i++) {
            listSubject = pupils.get(i).subjects();
            for (int j = 0; j < listSubject.size(); j++) {
                sumStudnts += listSubject.get(j).getScore();
            }
            sumSt = sumStudnts / listSubject.size();
            sumAvg += sumSt;
            sumStudnts = 0;
        }
        return sumAvg / pupils.size();
    }

    //*вычисляет средний балл по каждому ученику*/
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sumSt = 0;
        List<Subject> listSubject = new ArrayList<>();
        List<Label> rsl = new ArrayList<>();
        int i = 0;
        for (Pupil p : pupils) {
           listSubject = p.subjects();
            for (Subject s: listSubject) {
                sumSt += s.getScore();
            }
            rsl.add(new Label(p.name(), sumSt/listSubject.size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(AnalyzeByMap.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 90),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 60),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 60)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 50)
                                )
                        )
                )
        ));

    }
}