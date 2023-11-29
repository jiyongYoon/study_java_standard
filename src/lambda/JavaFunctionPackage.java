package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFunctionPackage {

    /*
    대부분의 메서드는 형태가 비슷하다.
    매개변수가 없거나 1개거나 2개,
    반환값이 없거나 1개,
    Generics를 사용하면 매개변수나 반환 타입이 달라도 공통적인 사용이 가능하다.
    => 이러한 특성을 활용하여 자주 사용되는 함수형 인터페이스를 미리 정의해 놓은것이
    ==> 바로 java.util.function 패키지 클래스들이다.
     */

    /*
      클래스        |        메서드          |   매개변수  |    반환값
    ---------------+-----------------------+------------+---------------
    Runnable       |         run()         |     X      |      X
    Supplier<T>    |         get()         |     X      |      T
    Consumer<T>    |     accept(T t)       |     T      |      X
    Function<T, R> |     R apply(T t)      |     T      |      R
    Predicate<T>   |   boolean test(T t)   |     T      |   boolean
     */

    public static void main(String[] args) {
        Supplier<Integer>           s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer>           c = i -> System.out.print(i + ", ");
        Predicate<Integer>          p = i -> i % 2 == 0;
        Function<Integer, Integer>  f = i -> i / 10 * 10; // i의 일의 자리를 없앰

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list); // [28, 8, 6, 58, 78, 42, 53, 99, 11, 45]
        System.out.println(list);
        printEvenNum(p, c, list); // [28, 8, 6, 58, 78, 42, ]
        List<Integer> newList = doSometing(f, list);
        System.out.println(newList); // [20, 0, 0, 50, 70, 40, 50, 90, 10, 40]
    }

    static <T> List<T> doSometing(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>();

        for (T t : list) {
            newList.add(f.apply(t));
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T t : list) {
            if (p.test(t)) {
                c.accept(t);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
