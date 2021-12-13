package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(e -> e.getScore())
                .average().orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(
                        pupil ->
                                new Tuple(
                                        pupil.getName(),
                                        pupil
                                                .getSubjects()
                                                .stream()
                                                .mapToInt(Subject::getScore)
                                                .average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.getSubjects().stream())
                .collect(Collectors.groupingBy( )).
    }
}
