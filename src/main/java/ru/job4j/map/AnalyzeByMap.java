package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
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
            rsl.add(new Label(p.name(), sumSt / listSubject.size()));
            sumSt = 0;
        }
        return rsl;
    }

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
            list.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sumSt = 0;
        List<Subject> listSubject = new ArrayList<>();
        List<Label> rsl = new ArrayList<>();
        int i = 0;
        for (Pupil p : pupils) {
            listSubject = p.subjects();
            for (Subject s: listSubject) {
                sumSt += s.getScore();
            }
            rsl.add(new Label(p.name(), sumSt));
            sumSt = 0;
        }
            Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
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
        List<Label> listLabel = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            listLabel.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(listLabel);
        return listLabel.get(listLabel.size() - 1);

    }

}