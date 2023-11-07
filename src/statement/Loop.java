package statement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loop {

    public static void main(String[] args) {


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(j);
                if (j == 1) {
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("위 아래 반복문은 동일함");
        Outer: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(j);
                if (j == 1) {
                    continue Outer;
                }
            }
        }
        System.out.println();
        System.out.println("위 아래 반복문은 동일함");
        List<Long> idList = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        Name: for (Long l : idList) {
            for (int i = 0; i < 3; i++) {
                System.out.print(i);
                if (i == 1) {
                    continue Name;
                }
            }
        }
    }

}