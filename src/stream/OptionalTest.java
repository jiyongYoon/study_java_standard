package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * T 타입을 감싸는 래퍼 클래스. 모든 클래스를 담을 수 있다.
 */
public class OptionalTest {

    public static void main(String[] args) {
        // Optional 객체 생성
        Optional<String> optVal = Optional.of("abc"); // Optional 객체 생성
        Optional<List<String>> optionalStringList = Optional.ofNullable(null); // Null 가능성이 있는 객체 생성
//        Optional<List<String>> errorList = Optional.of(null); // NullPointException
        Optional<String> emptyOptional = Optional.empty(); // 바람직한 Optional 객체
        Optional<String> nullOptional = null; // 오류는 없지만, Optional 객체를 쓰는 이유가 없음

        // Optional 객체 사용
        String str1 = optVal.get();
        String str2 = optVal.orElse("아무것도 없어요"); // .olElse()는 optional의 값이 null인 경우 변수에 담을 다른 값을 지정할 수 있다.

        // T orElseGet(Supplier<? extends T> other) & T orElseThrow(Supplier<? extends X> exceptionSupplier)
        String emptyStr1 = emptyOptional.orElse("emptyStr1");
        String emptyStr2 = emptyOptional.orElseGet(() -> "emptyStr2");
        System.out.println(emptyStr1); // emptyStr1
        System.out.println(emptyStr2); // emptyStr2
        // => 빈 값일때는 둘 다 같은 동작을 하는것 같지만, 빈 값이 아닌 상황에서 메서드를 넣으면 결과가 달라진다.
        String emptyStr3 = optVal.orElse(elseGetTest(3));
        String emptyStr4 = optVal.orElseGet(() -> elseGetTest(4));
        System.out.println(emptyStr3); // 메서드에 진입했습니다. abc
        System.out.println(emptyStr4); // abc
        /*
        ==> .orElse는 Optional 객체 값이 무엇이든 실행이 된 후 판단을 하고
        ==> .orElseGet은 Optional 객체 값이 null인 경우에만 Supplier 메서드를 실행한다.
         */

        if (optVal.isPresent()) {
            System.out.println("if 문 진입!");
        }

        optVal.ifPresent(str -> System.out.println("i값이 " + str + " 라서 consumer 실행!"));

        //////////////////////////////////////////////////////////////////////////////////////

        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr.get() = " + optStr.get()); // optStr.get() = abcde
        System.out.println("optInt.get() = " + optInt.get()); // optInt.get() = 5
        int result1 = Optional.of("123")
            .filter(x -> x.length() > 0)
            .map(Integer::parseInt).get();

        int result2 = Optional.of("")
            .filter(x -> x.length() > 0)
            .map(Integer::parseInt).orElse(-1);

        System.out.println("result1 = " + result1); // result1 = 123
        System.out.println("result2 = " + result2); // result2 = -1

        Optional.of("456").map(Integer::parseInt)
            .ifPresent(x -> System.out.println("result3 = " + x));

        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());

        System.out.println(optInt1.getAsInt());
        System.out.println(optInt2.getAsInt()); // Exception in thread "main" java.util.NoSuchElementException: No value present
    }

    public static String elseGetTest(int n) {
        System.out.println("메서드에 진입했습니다.");
        return "emptyStr" + n;
    }
}
