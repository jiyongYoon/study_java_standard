package lambda;

@FunctionalInterface // 해당 어노테이션은 마킹용에 불과함
interface MyFunction2 {
    void run();
}

public class LambdaExample2 {

    static void execute(MyFunction2 f) {
        f.run();
    }

    static MyFunction2 getMyFunction() {
        MyFunction2 f = () -> System.out.println("f3.run()" );
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 run() 구현
        MyFunction2 f1 = () -> System.out.println("f1.run()");

        // 익명클래스로 run() 구현
        MyFunction2 f2 = new MyFunction2() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        // 메서드로 구현된 run() 사용
        MyFunction2 f3 = getMyFunction();

        // 실행
        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("이 출력 메서드 자체가 run()인거임"));
    }
}
