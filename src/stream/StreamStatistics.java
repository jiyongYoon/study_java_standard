package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStatistics {

    public static void main(String[] args) {
        Student student1 = new Student("3반", 40, "1번학생");
        Student student2 = new Student("1반", 100, "2번학생");
        Student student3 = new Student("1반", 60, "3번학생");
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        long count1 = studentList.stream().count();
        long count2 = studentList.stream().collect(Collectors.counting());
        System.out.println(Objects.equals(count1, count2)); // true

        long totalScore1 = studentList.stream().mapToInt(Student::getTotalScore).sum();
        long totalScore2 = studentList.stream().collect(Collectors.summingInt(Student::getTotalScore));
        System.out.println(Objects.equals(totalScore1, totalScore2)); // true

        Optional<Student> topStudent1 = studentList.stream().max(Comparator.comparing(Student::getTotalScore));
        Optional<Student> topStudent2 = studentList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println(Objects.equals(topStudent1, topStudent2)); // true

        IntSummaryStatistics stat1 = studentList.stream().mapToInt(Student::getTotalScore).summaryStatistics();
        IntSummaryStatistics stat2 = studentList.stream().collect(Collectors.summarizingInt(Student::getTotalScore));
        System.out.println(stat1); // IntSummaryStatistics{count=3, sum=200, min=40, average=66.666667, max=100}
        System.out.println(stat2); // IntSummaryStatistics{count=3, sum=200, min=40, average=66.666667, max=100}

        Integer grandTotal1 = studentList.stream().map(Student::getTotalScore).reduce(0, Integer::sum);
        Integer grandTotal2 = studentList.stream().collect(Collectors.reducing(0, Student::getTotalScore, Integer::sum));
        System.out.println(Objects.equals(grandTotal1, grandTotal2));

        String collect1 = studentList.stream().map(Student::getName).collect(Collectors.joining(", ")); // 1번학생, 2번학생, 3번학생
        String collect2 = studentList.stream().map(Student::getName).collect(Collectors.joining(", ", "[", "]")); // [1번학생, 2번학생, 3번학생]
        System.out.println(collect1);
        System.out.println(collect2);

        ////////////////////////////////////////////////////

        List<Integer> integerList = new ArrayList<>();
        new Random().ints(1, 46).distinct().limit(6).forEach(integerList::add);

        Optional<Integer> max = integerList.stream().reduce(Integer::max);
        Optional<Integer> min = integerList.stream().reduce(Integer::min);
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }

}
