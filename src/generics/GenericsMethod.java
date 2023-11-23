package generics;

import generics.GenericsClass.Apple;
import generics.GenericsClass.Banana;
import generics.GenericsClass.Fruit;
import generics.GenericsClass.FruitBox;
import java.util.Comparator;
import java.util.List;

/** [Generics 메서드]
 * 선언 위치는 반환타입 바로 앞
 */
public class GenericsMethod {

    public static void main(String[] args) {
        SortingFruitBox<Fruit> 재료 = new SortingFruitBox<>();
        재료.list.add(new Apple());
        재료.list.add(new Banana());
        Juice juice = Mixer.makeJuice(재료);
        System.out.println(juice);
    }
}

class Juice {
    String name;

    public Juice(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SortingFruitBox<T> extends FruitBox<T> {
    static <T> void sort(List<T> list, Comparator<? super T> comparator) {

    }
}

class Mixer {
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
        String tmp = "";
        for (Fruit fruit : box.list) {
            tmp += fruit.name + " ";
        }
        return new Juice(tmp + "주스");
    }
}