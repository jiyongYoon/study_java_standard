package collections;

import java.util.HashSet;
import java.util.Objects;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet stringHashSet = new HashSet();
        stringHashSet.add("abc");
        stringHashSet.add("abc");
        Person personA = new Person("David", 10);
        Person personB = new Person("David", 10);
        stringHashSet.add(personA);
        stringHashSet.add(personB);

        System.out.println(stringHashSet); // [abc, David:10, David:10] -> new Person 두 객체를 다른 객체로 인식하기 때문에.
        // 같게 하려면 equals()와 hashCode()를 오버라이딩하여 name, age 값을 비교하도록 해야함.

        // hashCode를 값으로 구현하면 객체클래스@주소값 에서 주소값이 동일해진다.
        System.out.println(personA); // collections.HashSetTest$Person@7997aff7
        System.out.println(personB); // collections.HashSetTest$Person@7997aff7

    }

    static class Person {
        String name;
        int age;

//        public String toString() {
//            return name + ":" + age;
//        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age); // 원래 참조형 객체는 객체의 주소값으로 hash값을 만드는데, 이렇게 오버라이드를 하면 name, age로 hash값을 만듦.
        }
    }

}
