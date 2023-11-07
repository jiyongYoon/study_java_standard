package operator;

public class Operator {

    public static void main(String[] args) {
        /**
         * 형변환
         */

        double d = 85.4;
        int score = (int) d; // 명시적 형변환
        double score2 = score; // 자동 형변환 => 형변환이 안되는게 아니라, 컴파일러가 자동적으로 추가해주는 것임.

        System.out.println(d); // 85.4
        System.out.println(score); // 85
        System.out.println(score2); // 85.0


//        int score3 = d; // 이렇게 큰 범위(double)의 변수를 작은 범위(int)의 변수에 넣으려면 컴파일 에러가 발생한다.
//        java: incompatible types: possible lossy conversion from double to int => 값이 손실이 날거야.
        int score3 = (int) d; // 명시적 형변환은 큰 범위 -> 작은 범위로 캐스팅해도 개발자가 의도했다고 판단하여 형변환을 진행해준다.
        long l = Long.MAX_VALUE;
        int longInt = (int) l; // 명시적 형변환이라 캐스팅은 해주나, byte에 담을 수 없는 값으로 값이 정확하지 않게 됨.

        System.out.println(score3); // 85
        System.out.println(l); // 9223372036854775807
        System.out.println(longInt); // -1

        /**
         * 문자열 비교
         */

        String str = new String("java"); // 새로운 객체를 만듦
        boolean result = str.equals("java"); // 값 비교
        System.out.println(result); // true
        result = (str == "java"); // 주소값 비교
        System.out.println(result); // false

    }

}
