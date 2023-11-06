package variable;

public class Variable {

    public static void main(String[] args) {
        String str = new String("Java");
        String str2 = "Java";
        // 위 두 String은 차이가 있다. 이 후에 학습하기로 함.

        String name = "Yo" + "on"; // 문자 + 문자 = 문자 결합
        String str3 = name + 5; // 문자 + 문자 아닌 값 => 문자 아닌 값을 문자로 변환한 후 결합 : Yoon5
        System.out.println(str3);

        /**
         * 기본형과 참조형
         * 기본형(primitive type)은 실제 값(data)를 저장함.
         * 참조형(reference type)은 값이 저장된 주소 값(memory address)을 저장함. 
         * Java에서는 참조형 변수 간 연산을 할 수 없어 실제 연산에 사용되는 것은 모두 기본형 변수임. 
         */

        /**
         * 기본형의 자료 크기 
         * boolean - 1 byte
         * byte - 1 byte 
         * char - 2 byte 
         * int - 4 byte 
         * float - 4 byte 
         * long - 8 byte 
         * double - 8 byte
         */

        // 오버플로우
        Integer MAX_VALUE = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE = " + MAX_VALUE); // 2147483647
        Integer MAX_VALUE_OVERFLOW = MAX_VALUE + 1;
        System.out.println("MAX_VALUE + 1 = " + MAX_VALUE_OVERFLOW); // -2147483648
    }

}
