package generics;

import generics.GenericsClass.Apple;
import generics.GenericsClass.Banana;
import generics.GenericsClass.Fruit;
import generics.GenericsClass.FruitBox;

/**
 * Generics 타입의 형변환은 원시타입 <-> 지네릭 타입 모두 가능하나, 경고 알람이 뜸
 * Unchecked cast: 'generics.GenericsClass.FruitBox' to 'generics.GenericsClass.FruitBox<generics.GenericsClass.Apple>'
 */
public class GenericTypeCasting {

    public static void main(String[] args) {
        FruitBox<Banana> bananaBox = new FruitBox();
        FruitBox newBox = (FruitBox) bananaBox;

        FruitBox anyBox = new FruitBox();
        FruitBox<Apple> appleBox = (FruitBox<Apple>) anyBox;

    }
}
