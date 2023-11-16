package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Comparable: 기본 정렬기준을 구현하는데 사용
 * Comparator: 기본 정렬기준 외에 다른 기준으로 정렬하고자 할 때 사용
 */
public class ComparatorTest {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger", "", "4"};

        Arrays.sort(strArr); // String의 Comparable구현에 의한 정렬.
        System.out.println(Arrays.toString(strArr)); // [, 4, Dog, cat, lion, tiger] // 문자열의 오름차순은 공백, 숫자, 대문자, 소문자 순서

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
        System.out.println(Arrays.toString(strArr)); // [, 4, cat, Dog, lion, tiger]

        Arrays.sort(strArr, Collections.reverseOrder()); // 역순
        System.out.println(Arrays.toString(strArr)); // [tiger, lion, cat, Dog, 4, ]

        BookDto bookDto1 = new BookDto("자바의 정석", 15000);
        BookDto bookDto2 = new BookDto("토비의 스프링", 40000);

        List<BookDto> bookDtoList = new ArrayList<>(Arrays.asList(bookDto1, bookDto2));
        Collections.sort(bookDtoList);
        System.out.println(bookDtoList); // [BookDto{name='토비의 스프링', price=40000}, BookDto{name='자바의 정석', price=15000}]
    }

    static class BookDto implements Comparable<BookDto> {
        String name;
        Integer price;

        @Override
        public String toString() {
            return "BookDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
        }

        public BookDto(String name, Integer price) {
            this.name = name;
            this.price = price;
        }


        @Override
        public int compareTo(BookDto o) {
            return o.price - this.price;
        }
    }

}
