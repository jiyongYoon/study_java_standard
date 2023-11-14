package object_class;

public class Main {

    /*
    [Object 클래스의 메서드]

    1. protected Object clone(): 객체 자신의 복사본을 반환한다.
    2. public boolean equals(Object obj): 객체 자신과 객체 obj가 같은 객체인지 알려준다. (참조값 반환)
    3. protected void finalize(): 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이때 수행되어야 하는 코드가 있을 때 오버라이딩한다. (거의 사용 안함)
    4. public Class getClass(): 객체 자신의 클래스 정보를 담고있는 Class인스턴스를 반환한다.
    5. public int hashCode(): 객체 자신의 해시코드를 반환한다.
    6. public String toString(): 객체 자신의 정보를 문자열로 반환한다.
    7. public void notify(): 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
    8. public void notifyAll(): 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
    9. public void wait(): 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간 동안 기다리게 한다.
    (7, 8, 9는 쓰레드와 관련된 것)
     */

    static class Value {
        int v;

        public Value(int v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 1;

        Value v1 = new Value(1);
        Value v2 = new Value(1);

        System.out.println(a.equals(b)); // true
        System.out.println(v1.equals(v2)); // false

        System.out.println(a.hashCode()); // 1 -> Integer는 그냥 그 값을 return하도록 오버라이딩 되어있음.
        System.out.println(b.hashCode()); // 1

        System.out.println(v1.hashCode()); // 2054798982
        System.out.println(v2.hashCode()); // 885951223

        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.hashCode()); // 99162322
        System.out.println(s2.hashCode()); // 99162322

        System.out.println(System.identityHashCode(s1)); // 191382150 -> 객체의 주소값으로 해시값을 만들기 때문에 값이 다름
        System.out.println(System.identityHashCode(s2)); // 142666848 -> 객체의 주소값으로 해시값을 만들기 때문에 값이 다름


    }

}
