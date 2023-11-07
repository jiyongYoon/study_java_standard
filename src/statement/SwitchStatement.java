package statement;

public class SwitchStatement {

    public enum Type {
        FOOTBALL,
        BASKETBALL,
        BASEBALL

    }

    public static void main(String[] args) {

        /**
         * switch문의 제약조건
         * 1. 조건식의 결과는 정수 또는 문자열이어야 한다.
         * 2. case 문의 값은 정수 상수(문자 포함), 문자열만 가능하며 중복되면 안된다.
         */

        int result = 0;
        int num;
        final int ONE = 1;

        switch (result) { // 조건식의 결과는 정수 또는 문자열이어야 함
            case '1': // 가능 (문자 리터럴)
            case ONE: // 가능 (정수 상수)
//            case "YES": // 문법으로는 가능하나, result가 int형이라 컴파일 에러
//            case num: // 변수 불가
//            case 1.0: // 실수 불가
        }

        Type type = Type.BASEBALL;

        switch (type) {
            case FOOTBALL:
            case BASEBALL:
            case BASKETBALL:
        }
    }

}
