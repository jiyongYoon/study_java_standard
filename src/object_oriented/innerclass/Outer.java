package object_oriented.innerclass;

public class Outer {

    // 내부 클래스
    class InstanceInner {
        int iv = 100;
//        static int cv = 100; // 컴파일 에러 -> static 선언 불가
        final static int CONST = 100; // final static은 상수라 허용
    }

    // 내부 static 클래스
    static class StaticInner {
        int iv = 200;
        static int cv = 200; // static 클래스에서는 static 변수 선언 가능
    }

    void myMethod() {
        // 지역 클래스
        class LocalInner {
            int iv = 300;
//            static int cv = 300; // 컴파일 에러 -> static 선언 불가
            final static int CONST = 300; // final static은 상수라 허용
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);

        Outer outer = new Outer();
        InstanceInner oi = outer.new InstanceInner(); // 내부 클래스는 Outer 인스턴스로만 생성가능
        StaticInner staticInner = new StaticInner(); // 내부 static 클래스는 인스턴스 생성 가능
//        LocalInner localInner = new LocalInner(); // 지역 클래스 사용 불가

        System.out.println(oi.getClass());
        System.out.println(staticInner.getClass());
    }

}
