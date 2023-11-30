package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPartitioningAndGrouping {

    public static void main(String[] args) {
        Student student1 = new Student("3반", 40, "1번학생", true);
        Student student2 = new Student("1반", 100, "2번학생", false);
        Student student3 = new Student("1반", 60, "3번학생", false);
        Student student4 = new Student("2반", 750, "4번학생", true);
        List<Student> studentList = Arrays.asList(student1, student2, student3, student4);

        Map<Boolean, List<Student>> studentGroupBySex = studentList.stream()
            .collect(Collectors.partitioningBy(Student::isMale));
        System.out.println(studentGroupBySex);
        /*
         {
              false=[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}, Student{ban='1반', totalScore=60, name='3번학생', isMale=false}],
              true=[Student{ban='3반', totalScore=40, name='1번학생', isMale=true}, Student{ban='2반', totalScore=750, name='4번학생', isMale=true}]
         }
         */

        Map<Boolean, Long> studentNumBySex = studentList.stream()
            .collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
        System.out.println(studentNumBySex); // {false=2, true=2}

        Map<Boolean, Optional<Student>> topScoreBySex = studentList.stream()
            .collect(
                Collectors.partitioningBy(
                    Student::isMale,
                    Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)))
            );
        System.out.println(topScoreBySex);
        /*
        {
            false=Optional[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}],
            true=Optional[Student{ban='2반', totalScore=750, name='4번학생', isMale=true}]
        }
        */

        // 2중 분할
        Map<Boolean, Map<Boolean, List<Student>>> failedStudentBySex = studentList.stream()
            .collect(
                Collectors.partitioningBy(
                    Student::isMale,
                    Collectors.partitioningBy(student -> student.getTotalScore() < 70)
            )
        );
        System.out.println(failedStudentBySex);
        /*
        {
            false={
                false=[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}],
                true=[Student{ban='1반', totalScore=60, name='3번학생', isMale=false}]
            },
            true={
                false=[Student{ban='2반', totalScore=750, name='4번학생', isMale=true}],
                true=[Student{ban='3반', totalScore=40, name='1번학생', isMale=true}]
            }
        }
         */

        //////////////////////////////////////////////////////////////////////////////////

        Map<String, List<Student>> studentByBan = studentList.stream()
            .collect(Collectors.groupingBy(Student::getBan));
        System.out.println(studentByBan);
        /*
        {
            3반=[Student{ban='3반', totalScore=40, name='1번학생', isMale=true}],
            2반=[Student{ban='2반', totalScore=750, name='4번학생', isMale=true}],
            1반=[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}, Student{ban='1반', totalScore=60, name='3번학생', isMale=false}]
        }
         */

        Map<String, List<Student>> studentByBanSorted = studentList.stream()
            .collect(Collectors.groupingBy(Student::getBan,
                Collectors.mapping(student -> student, Collectors.toList())))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey()) // 오름차순 정렬
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(studentByBanSorted);
        /*
        {
            1반=[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}, Student{ban='1반', totalScore=60, name='3번학생', isMale=false}],
            2반=[Student{ban='2반', totalScore=750, name='4번학생', isMale=true}],
            3반=[Student{ban='3반', totalScore=40, name='1번학생', isMale=true}]
        }

         */

        Map<Boolean, Map<String, List<Student>>> studentBySexAndBan = studentList.stream()
            .collect(
                Collectors.groupingBy(Student::isMale,
                    Collectors.groupingBy(Student::getBan))
            );
        System.out.println(studentBySexAndBan);
        /*
        {
            false={
                1반=[Student{ban='1반', totalScore=100, name='2번학생', isMale=false}, Student{ban='1반', totalScore=60, name='3번학생', isMale=false}]
            },
            true={
                3반=[Student{ban='3반', totalScore=40, name='1번학생', isMale=true}],
                2반=[Student{ban='2반', totalScore=750, name='4번학생', isMale=true}]
            }
        }
        */
    }

}