package lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

    // 람다식이 하나의 메서드만 호출하는 경우, 메서드 참조를 사용할 수 있다.
    public static void main(String[] args) {
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> f2 = Integer::parseInt;

        Supplier<MyClass> s = () -> new MyClass();
        Supplier<MyClass> s2 = MyClass::new;
    }
}

class MyClass {

    public MyClass() {
    }
}
