package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double summa = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summa += subject.getScore();
                count++;
            }
        }
        return summa / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double summa = 0;
        int count = 0;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summa += subject.getScore();
                count++;
            }
            labelList.add(new Label(pupil.name(), summa / count));
            summa = 0;
            count = 0;
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> scoreSubjects = new LinkedHashMap<>();
        int countPupils = pupils.size();
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSubjects.put(subject.getName(), scoreSubjects.getOrDefault(subject.getName(), 0) + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> scoreSubject : scoreSubjects.entrySet()) {
            labelList.add(new Label(scoreSubject.getKey(), (double) scoreSubject.getValue() / countPupils));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double summa = 0;
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summa += subject.getScore();
            }
            labelList.add(new Label(pupil.name(), summa));
            summa = 0;
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.isEmpty() ? null : labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> scoreSubjects = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreSubjects.put(subject.getName(), scoreSubjects.getOrDefault(subject.getName(), 0) + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> scoreSubject : scoreSubjects.entrySet()) {
            labelList.add(new Label(scoreSubject.getKey(), (double) scoreSubject.getValue()));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.isEmpty() ? null : labelList.get(labelList.size() - 1);
    }
}