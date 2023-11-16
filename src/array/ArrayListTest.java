package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

        List list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list2.add(6);
        System.out.println(list2);

    }

}
