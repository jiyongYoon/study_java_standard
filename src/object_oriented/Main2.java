package object_oriented;

public class Main2 {

    static class Car {
        String color;
        String gearType;
        int door;
        static String brand;

        /**
         * 생성자: 인스턴스 변수를 초기화 하는 메서드. <br>
         * 인스턴스를 실제로 `생성`하는 것은 아니다. `생성`은 연산자 new가 하게 된다.
         */

        // 기본생성자. 클래스에 정의된 생성자가 없는 경우 컴파일러가 기본생성자를 만들어줌.
//        Car() {
//        }

        Car() {
            this("black", "auto", 4); // 이 클래스의 AllArgs 생성자를 호출
        }

        Car(String color) {
            this(color, "auto", 4); // this는 이 클래스의 기본생성자를 호출하게 됨.
        }

        static void setBrand() {
//            this.gearType = "auto"; // 컴파일 에러 -> 클래스 메서드에서는 인스턴스를 가리키는 this를 사용할 수 없다.
            brand = "tesla";
        }

        public Car(String color, String gearType, int door) {
            this.color = color;
            this.gearType = gearType;
            this.door = door;
        }

        @Override
        public String toString() {
            return "Car{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("white");
        Car car3 = new Car("blue", "manual", 2);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }

}
