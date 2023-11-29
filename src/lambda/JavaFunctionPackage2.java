package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaFunctionPackage2 {

    /*
    컬렉션 프레임워크에 함수형 인터페이스가 도입되었다.
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list 모든 요소 출력: forEach(Consumer<T> action)
        list.forEach(integer -> System.out.print(integer + ", ")); // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        System.out.println();


        // list에서 2, 3의 배수 제거: removeIf(Predicate<E> filter)
        list.removeIf(integer -> integer % 2 == 0 || integer % 3 == 0);
        System.out.println(list); // [1, 5, 7]

        // list의 각 요소에 10을 곱함
        list.replaceAll(integer -> integer * 10);
        System.out.println(list); // [10, 50, 70]

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소 {k, v} 형태로 출력
        map.forEach((k, v) -> System.out.print("{" + k + ", " + v + "}, ")); // {1, 1}, {2, 2}, {3, 3}, {4, 4},
        System.out.println();
    }

}
