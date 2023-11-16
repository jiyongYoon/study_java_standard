package array;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] score = new int[5]; // score 변수에 배열의 시작점 참조값이 저장됨. 배열은 각 저장공간이 길이만큼 연속적으로 배치되어 있다.
        int length = score.length; // 배열이름.length는 JVM이 관리하는 상수. 배열은 최초 선언되면 길이가 정해지기 때문에 값을 변경할 수 없다.
//        score.length = 3; // 불가능

        int[] arr;
//        arr = {5, 6, 7, 8, 9}; // 불가능
        int[] arr2 = {5, 6, 7, 8, 9}; // 배열의 선언과 같이 쓸때만 new int[]를 생략하여 초기화 가능.

        /**
         * 배열의 출력
         */

        System.out.print("[");
        for (int i = 0; i < arr2.length; i++) {
            if (i == arr2.length - 1) {
                System.out.print(arr2[i]);
            } else {
                System.out.print(arr2[i] + ", ");
            }
        }
        System.out.println("]");
        System.out.println("위아래 출력값은 모두 [5, 6, 7, 8, 9] 로 동일합니다.");
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr2); // [I@1a407d53 -> 타입@주소값

        char[] charArr = {'a', 'b', 'c', 'd'};
        System.out.println(charArr); // abcd -> print함수가 char 배열을 받을때만 이렇게 동작하도록 되어있음.

        /**
         * 변수의 기본값
         */
        boolean[] boolArr = new boolean[5]; // boolean의 기본값 false
        System.out.println(Arrays.toString(boolArr)); // [false, false, false, false, false]

        int[] intArr = new int[3]; // int의 기본값 0
        System.out.println(Arrays.toString(intArr)); // [0, 0, 0]

        String[] strArr = new String[4]; // String 등 참조형의 기본값 null
        System.out.println(Arrays.toString(strArr)); // [null, null, null, null]

        /**
         * String은 char의 배열 클래스
         */
        String java = "Java";
        java += "8"; // 기존 java의 문자열에 8이 추가된 것처럼 보이지만, 실제로는 새로운 객체가 만들어진 것.
        System.out.println(java); // Java8
        // 변경 가능한 문자열을 다루려면 StringBuilder, StringBuffer 등의 클래스 사용

        System.out.println(java.charAt(java.length() - 1)); // 8
        System.out.println(java.substring(0, 4)); // Java
        System.out.println(java.equals("Java8")); // true
        System.out.println(java == "Java8"); // false
        char[] charArray = java.toCharArray();// 문자 배열 char[]로 변환됨

        /**
         * 다차원 배열
         */

        // 가독성 좋게 배열
        int[][] field = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };

        System.out.println(field[0][2] == 3);
        System.out.println(field[1][0] == 5);

        int[][] field2 = Arrays.copyOf(field, field.length); // 배열 복사 -> 깊은 복사구나

        System.out.println(Arrays.deepEquals(field, field2)); // true -> 다차원 배열의 비교는 Arrays.deepEquals(A, B)
        System.out.println(Arrays.deepToString(field)); // [[1, 2, 3, 4], [5, 6, 7, 8]] -> 다차원 배열의 출력

        int[] intArr1 = {1, 2, 3};
        int[] intArr2 = Arrays.copyOf(intArr1, intArr1.length);
        intArr1 = new int[]{4, 5, 6};

        System.out.println(Arrays.toString(intArr1)); // {4, 5, 6}
        System.out.println(Arrays.toString(intArr2)); // {1, 2, 3}
    }

}
