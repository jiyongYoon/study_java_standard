package exception;

public class MyException2 {

    public static void main(String[] args) {
        System.out.println("시작");
        try {
            Exception e = new Exception("내가 만든 예외~");
            throw e; // 이게 없으면 예외 안남. Exception을 만드는거 자체는 예외발생이 아니기 때문.
        } catch (Exception e) {
            System.out.println("에러 메시지: " + e.getMessage());
        }
        System.out.println("종료");
        /**
         * 시작
         * 에러 메시지: 내가 만든 예외~
         * 종료
         */

        try {
           throwMyException();
        } catch (Exception e) {
            System.out.println("에러 메시지: " + e.getMessage());
        }
    }

    static void throwMyException() throws Exception {
        Exception e = new Exception("일부러 던지는 에러");
        throw e;
    }
}
