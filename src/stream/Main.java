package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림 클래스는 컬랙션 최고 조상인 Collection에 정의되어 있다.
 * 생성 -> 중간연산 -> 최종연산 순으로 구성되어 있으며, 중간연산은 n번 가능하다.
 */
public class Main {

    public static void main(String[] args) {
        /* 스트림 생성 */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream(); // list를 소스로 하는 스트림 생성

        // 스트림 재사용 불가
        stream.forEach(System.out::print); // 12345
//        stream.forEach(System.out::println); // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        System.out.println();

        /* 스트림 중간연산 */
        /*
        Stream<T> distinct()                        - 중복 제거
        Stream<T> filter(Predicate<T> predicate)    - 조건에 안 맞는 요소 제외
        Stream<T> limit(long maxSize)               - 스트림의 일부를 잘라냄
        Stream<T> skip(long n)                      - 스트림의 일부를 건너뜀
        Stream<T> peek(Consumer<T> action)          - 스트림의 요소에 작업수행
        Stream<T> sorted()
        Stream<T> sorted(Comparator<T> comparator)  - 스트림의 요소를 정렬함
        Stream<R> map(Function<T, R> mapper)        - 스트림의 요소를 반환함
                  mapToDouble, mapToInt, mapToLong
                  flatMap(Function<T, Stream<R>> mapper)
                  flatMapToDouble, flatMapToInt, flatMapToLong
         */
        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        intStream1.skip(3).limit(5).forEach(System.out::print); // 45678
        System.out.println();

        IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 3, 4, 4, 5, 6);
        intStream2.distinct().forEach(System.out::print); // 123456
        System.out.println();

        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        IntStream intStream4 = IntStream.rangeClosed(1, 10);
        intStream3.filter(i -> i % 2 != 0).filter(i -> i % 3 != 0).forEach(System.out::print); // 157
        System.out.println();
        intStream4.filter(i -> i % 2 != 0 && i % 3 != 0).forEach(System.out::print); // 157
        System.out.println();

        Stream<String> strStream1 = Stream.of("d", "b", "a", "f", "c", "e");
        strStream1.sorted().forEach(System.out::print); // abcdef
        System.out.println();

        Stream<String> strStream2 = Stream.of("d", "b", "a", "f", "c", "e");
        strStream2.sorted(Comparator.reverseOrder()).forEach(System.out::print); // fedcba
        System.out.println();

        Stream<String> strStream3 = Stream.of("d", "b", "a", "f", "c", "e");
        strStream3.sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::print); // abcdef
        System.out.println();

        // 객체 정렬
        Student student1 = new Student("3반", 40, "1번학생");
        Student student2 = new Student("1반", 100, "2번학생");
        Student student3 = new Student("1반", 60, "3번학생");
        Stream<Student> studentStream1 = Stream.of(student1, student2, student3);
        // 반별 -> 성적 -> 이름 순으로 청졀
        studentStream1.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Student::getTotalScore)
                .thenComparing(Student::getName))
            .forEach(System.out::println);
        System.out.println();
        /*
        Student{ban='1반', totalScore=60, name='3번학생'}
        Student{ban='1반', totalScore=100, name='2번학생'}
        Student{ban='3반', totalScore=40, name='1번학생'}
         */

        Stream<Student> studentStream2 = Stream.of(student1, student2, student3);
        studentStream2.map(Student::getName)
            .filter(s -> s.endsWith("학생"))
            .forEach(System.out::println);
        System.out.println();

        Stream<Student> studentStream3 = Stream.of(student1, student2, student3);
        studentStream3.filter(student -> student.getTotalScore() > 50)
            .peek(System.out::println)
            .map(Student::getName)
            .forEach(System.out::println);
        System.out.println();
        /* 한 요소의 최종연산이 다 끝난 후에야 다음 요소의 연산작업이 시작된다!!!
        Student{ban='1반', totalScore=100, name='2번학생'}
        2번학생
        Student{ban='1반', totalScore=60, name='3번학생'}
        3번학생
         */

        // FlatMap
        Stream<String[]> strArrStream = Stream.of(
            new String[]{"abc", "def", "jkl"},
            new String[]{"ABC", "DEF", "JKL"}
        );

        Stream<String> stringStream = strArrStream.flatMap(Arrays::stream);
        stringStream.map(String::toLowerCase)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        /*
        abc
        def
        jkl
         */
        System.out.println();

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not there is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
            .map(String::toLowerCase)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        /*
        believe
        do
        is
        it
        no
        not
        or
        there
        true
        try
         */
        System.out.println();


        /* 스트림 최종연산 */
        /* reduce, collect가 핵심!!
        void forEach(Consumer<? super T> action)                - 각 요소에 지정된 작업 수행
        void forEachOrdered(Consumer<? super T> action)
        long count()                                            - 스트림의 요소 개수 반환
        Optional<T> findAny/findFirst()                         - 스트림의 요소 아무거나/최초 하나 반환
        Optional<T> max/min(Comparator<? super T> comparator)   - 스트림의 최대/최소값 반환
        boolean allMatch/anyMatch/noneMatch(Predicate<T> p)     - 각 조건을 모든 요소, 한 요소라도, 하나도 만족시키지 않는지
        Object[] toArray()                                      - 스트림의 모든 요소를 배열로 반환
        A[]      toArray(IntFunction<A[]> generator)
        Optional<T> reduce(BinaryOperator<T> accumulator)       - 스트림의 요소를 하나씩 줄여가면서 계산함
        T reduce(T identity, BinaryOperator<T> accumulator)
        U reduce(U identity, BiFunction<U, T, U> accumulator, BinaryOperator<U> combiner)
        R collect(Collector<T, A, R> collector)                 - 스트림의 모든 요소를 수집하여 반환함
        R collect(Supplier<R> supplier, BiConsumer<R, T> accumulator, BiConsumer<R, R> combiner)
         */

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // reduce(초기값, ( a, b ) -> Binary 람다 연산 식)
        int count = integerList.stream().reduce(0, (a, b) -> a + 1);
        int sum = integerList.stream().reduce(0, (a, b) -> a + b);
        int max = integerList.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        int min = integerList.stream().reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max = " + max);
        System.out.println("min = " + min);

        List<String> stringList = new ArrayList<>(Arrays.asList("하나", "둘", "셋", "넷", "다섯"));

        String 완성 = stringList.stream().reduce("시작", (a, b) -> a + " " + b);
        System.out.println(완성); // 시작 하나 둘 셋 넷 다섯
    }

}

class Student {
    String ban;
    Integer totalScore;
    String name;

    public String getBan() {
        return ban;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
            "ban='" + ban + '\'' +
            ", totalScore=" + totalScore +
            ", name='" + name + '\'' +
            '}';
    }

    public Student(String ban, Integer totalScore, String name) {
        this.ban = ban;
        this.totalScore = totalScore;
        this.name = name;
    }
}
