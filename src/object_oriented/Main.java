package object_oriented;

public class Main {

    /**
     * 클래스: 객체(인스턴스)를 생성하기 위한 틀 <br>
     * 클래스는 속성(Field)과 기능(Method)으로 구성되어 있다. <br>
     * 기능은 해당 인스턴스의 속성을 다루는 것이기 때문에 관계가 깊어, 클래스 내부에 정의하도록 한다.
     */
    static class TV {

        // 클래스 변수: 모든 인스턴스가 공통된 저장공간(변수)를 공유한다.
        static String brand;

        // 아래는 인스턴스 변수: 각 인스턴스 고유의 저장공간을 가진다.
        // 기본형 인스턴스 변수
        String color;
        boolean power;
        int channel;

        // 참조형 인스턴스 변수
        TV_LACK tvLack;

        // 인스턴스 메서드
        void power() {
            this.power = !power;
        }

        void channelUp() {
            ++channel;
        }

        void channelDown() {
            --channel;
        }

        // 클래스 메서드
        static boolean isMBC(int channel) { // 파라미터도 지역변수로 취급
            int mbcChannel = 11; // 지역변수: 메서드 scope 내에서만 유효하며, scope를 벗어나면 소멸됨.
            return channel == mbcChannel;
        }

        // 기본형 매개변수는 값을 읽기만 할 수 있음 -> 이 메서드는 의도한 대로 동작되지 않음.
        static void changeMBC(int channel) {
            int mbcChannel = 11;
            System.out.println("채널 바꾸기 시도: 기존 채널 " + channel + " -> " + mbcChannel);
            channel = mbcChannel;
        }

        // 참조형 매개변수는 주소값으로 인스턴스의 속성에 잭접 접근하여 값을 변경할 수 있음.
        static void 벽걸이공사(TV_LACK tvLack) {
            String wall = "벽걸이";
            System.out.println("거치방법 바꾸기 시도: 기존 거치 " + tvLack.type + " -> " + wall);
            tvLack.type = wall;
        }

        static void 색칠(TV tv) {
            String blue = "파랑";
            System.out.println("색깔 바꾸기 시도: 기존 색깔 " + tv.color + " -> " + blue);
            tv.color = blue;
        }
    }

    static class TV_LACK {
        String type;

    }

    public static void main(String[] args) {
        TV_LACK stand = new TV_LACK();
        stand.type = "스탠드";

        TV t; // 변수 선언 -> 메모리에 t라는 TV 타입의 참조형 변수가 선언되고, 주소값을 저장할 수 있는 공간이 마련됨.
        t = new TV(); // TV라는 객체로 인스턴스가 생성되고, 인스턴스의 주소값이 t에 입력됨. 그 주소값으로 가면 color, power, channel과 같은 필드들이 있고, 메서드들도 메모리 공간을 차지하고 있다.
        // 이제 우리는 TV 인스턴스를 t라는 참조변수를 통해서만 다루게 된다. 마치 TV 리모컨처럼 t.channel, 이런 식으로 다루게 되는 것이다.
        t.channel = 7;
        t.color = "검정";
        t.tvLack = stand;

        TV t2 = new TV();
        t2.channel = 11;

        TV.brand = "samsung"; // 클래스 변수에 값을 할당했는데, 각 인스턴스들에도 모두 공유가 된다.

        System.out.println(TV.brand);
        System.out.println(t.brand);
        System.out.println(t2.brand);

        // System.out.println(TV.channel); // 이런 접근은 불가능
        System.out.println(t.channel);
        System.out.println(t2.channel);

        System.out.println(TV.isMBC(t.channel));
        System.out.println(TV.isMBC(t2.channel));

        if (t.channel != 11) {
            TV.changeMBC(t.channel); // 채널 바꾸기 시도: 기존 채널 7 -> 11
        }
        System.out.println(t.channel); // 7

        System.out.println(t.tvLack.type);
        TV.벽걸이공사(t.tvLack);
        System.out.println(t.tvLack.type);

        System.out.println(t.color);
        TV.색칠(t);
        System.out.println(t.color);
    }

}
