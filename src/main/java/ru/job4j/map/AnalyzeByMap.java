package ru.job4j.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            sumSt = 0;
        }
        return rsl;
    }

    //*вычисляет средний балл по каждому предмету//
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subject.getScore();
                if (map.containsKey(subject.getName())) {
                    score = map.get(subject.getName()) + score;
                }
                map.put(subject.getName(), score);
            }
        }
        List<Label> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()/pupils.size()));
        }

        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }

}