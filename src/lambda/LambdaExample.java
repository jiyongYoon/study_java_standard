package lambda;

import java.util.Arrays;

public class LambdaExample {

    /**
     * 람다는 메서드를 하나의 '식'으로 표현한 것. <br>
     * 익명 객체이다.
     * 람다식은 메서드에서 이름타입과 반환타입을 제거하고 매개변수 선언부와 몸통 {} 사이에 -> 를 추가하면 된다.
     *
     *     int max (int a, int b) {
     *         return a > b ? a : b;
     *     }
     *                 |
     *                 V
     *     (int a, int b) -> { return a > b ? a : b; }
     */
    public static void main(String[] args) {
        // 람다식 예시
        int[] arr = new int[5];
        Arrays.setAll(arr, (int i) -> (int) (Math.random() * 5) + 1);

        //////////////////////////////////////////////////////////////////

        MyFunction myFunction = new MyFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        int big = myFunction.max(5, 12);
        System.out.println(big);

        //////////////////////////////////////////////////////////////////

        MyFunction myFunction2 = (int a, int b) -> a > b ? a : b;
        int big2 = myFunction2.max(5, 12);
        System.out.println(big2);

        //////////////////////////////////////////////////////////////////

        MyFunction myFunction3 = (int a, int b) -> a > b ? a : b;
        aMethod(myFunction3); // 람다 식을 매개변수로 사용

        //////////////////////////////////////////////////////////////////
    }

    // 람다 식을 가진 함수형 인터페이스를 매개변수로 사용 -> 대표적인 메서드: Runnable
    static void aMethod(MyFunction f) {
        f.max(5, 12);
    }

}

/**
 * 람다식은 익명 객체이다. 따라서 참조변수로 람다식을 사용할 수 있다.
 * 이러한 람다식을 담는 객체(클래스)를 `함수형 인터페이스`라고 한다.
 */
@FunctionalInterface
interface MyFunction {
    int max(int a, int b);
}
