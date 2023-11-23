package generics;

import java.util.ArrayList;

/** [Generics 클래스]
 * 다양한 타입의 객체들을 다루는 메서드나 컬랙션 클래스에 `컴파일 시점`에 타입 체크를 할 수 있도록 해주는 기능. <br>
 * 컴파일 후에는 Generics는 타입이 제거되고 원시 타입만 남게 된다.(라고 하는데, IDE에서 디컴파일 하니까 있는데...?)
 *      => 이렇게 하는 이유는 Generics가 도입되기 이전인 JDK 1.5 이전 소스코드와의 호환성을 유지하기 위해서라고 한다.
 *      => 컴파일러는 필요한 곳에 형변환을 넣어주고 Generics 타입을 지워주는 작업을 한다고 한다.
 *      => 결국 형변환을 개발자가 귀찮게 하게 할 것인가, 컴파일러에게 맡길 것인가의 문제였구만.
 */
public class GenericsClass {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Object e");

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("String e");
//        stringArrayList.add(1); // 컴파일 에러

        FruitBox<Integer> integerFruitBox = new FruitBox<>();
        integerFruitBox.list.add(1);

        RealFruitBox<Fruit> fruitBox = new RealFruitBox<>();
        fruitBox.list.add(new Fruit(""));
        fruitBox.list.add(new Banana());

        RealFruitBox<Banana> bananaBox = new RealFruitBox<>(); // Fruit 상속 타입으로는 생성 가능
        bananaBox.list.add(new Banana());
//        bananaBox.list.add(new Fruit()); // 부모 타입은 당연히 불가능

//        EatableRealFruitBox<Banana> eatableBananaBox = new EatableRealFruitBox<Banana>(); // Banana는 Eatable을 구현하지 않아서 컴파일 에러
        EatableRealFruitBox<Apple> eatableAppleBox = new EatableRealFruitBox<>();
        eatableAppleBox.list.add(new Apple());

        /**
         * [Generics의 와일드카드]
         *
         * <? extends T>    와일드 카드의 상한 제한. T 와 그 자손들만 가능
         * <? super T>      와일드 카드의 하한 제한. T 와 그 조상들만 가능
         * <?>              모든 타입 가능 == <? extends Object>
         */

    }

    /*
    Generics 타입 제한 없음
     */
    static class FruitBox<T> {
         ArrayList<T> list = new ArrayList<>();
//         static T item; // static 변수는 Generics 사용 불가
        T item;
//        T[] items = new T[5]; // Generics 배열도 생성 불가 -> new 연산자는 컴파일 시점에 타입이 뭔지 정확하게 알아야 하기 때문. 해당 위치에서는 T 클래스가 뭔지 모르기 때문에 Generics 배열 생성 불가
    }

    /*
    Generics 타입 제한 있음
     */
    static class RealFruitBox<T extends Fruit> {
        ArrayList<T> list = new ArrayList<>();
    }

    /*
    Generics 타입 + 인터페이스 제한 있음
     */
    static class EatableRealFruitBox<T extends Fruit & Eatable> {
        ArrayList<T> list = new ArrayList<>();
    }

    static class Fruit {
        String name;

        public Fruit(String name) {
            this.name = name;
        }
    }

    static class Banana extends Fruit {

        public Banana() {
            super("바나나");
        }
    }

    static class Apple extends Fruit implements Eatable {

        public Apple() {
            super("사과");
        }

        @Override
        public void eat() {
            System.out.println("아삭아삭");
        }
    }

    interface Eatable {
        void eat();
    }

}
