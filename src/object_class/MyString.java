package object_class;

import java.util.StringJoiner;

public class MyString {

    /*
    String 클래스는 final 키워드가 있어서 다른 클래스의 조상이 될 수 없다. 즉, 다른 클래스가 String 클래스를 상속받을 수 없다.
     */


    public static void main(String[] args) {
        String str1 = "abc"; // 문자열 리터럴 "abc"의 주소가 str1에 저장됨
        String str2 = "abc"; // 문자열 리터럴 "abc"의 주소가 str2에 저장됨
        String str3 = new String("abc"); // 새로운 String 인스턴스 생성
        String str4 = new String("abc"); // 새로운 String 인스턴스 생성

        System.out.println("str1 == str2 = " + str1 == str2); // true
        System.out.println("str1.equals(str2) = " + str1.equals(str2)); // true
        System.out.println();

        System.out.println("str3 == str4 = " + str3 == str4); // false
        System.out.println("str3.equals(str4) = " + str3.equals(str4)); // true

        /*
        문자열 리터럴?

        자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장된다.
        이 때, 같은 내용의 문자열 리터럴은 한번만 저장된다. JVM에 있는 리터럴 풀에 저장되며, 그렇기 때문에 같은 객체 주소를 갖게 된다.
         */

        System.out.println(str1.concat(str2).concat(str3).concat(str4));

        String a = "a";
        String b = "b";

        System.out.println(a.compareTo(b)); // -1
        System.out.println(b.compareTo(a)); // 1
        System.out.println(a.compareTo(a)); // 0


        String animals = "dog,cat,bear";
        String[] animalsArr = animals.split(",");

        StringJoiner stringJoiner = new StringJoiner("/", "(", ")");
        for (String animal : animalsArr) {
            stringJoiner.add(animal);
        }

        System.out.println(String.join("-", animalsArr)); // dog-cat-bear
        System.out.println(stringJoiner.toString()); // (dog/cat/bear)

    }

}
