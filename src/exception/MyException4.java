package exception;

/**
 * 과거에는 Exception을 상속받아서 checked 예외로 많이 사용했다. -> 반드시 코드레벨에서 예외처리 필요
 * 요즘에는 선택적으로 예외처리를 하도록 RuntimeException을 상속받아 만드는 쪽으로 변하고 있다. -> 코드레벨에서 Exception 처리 필요 없음
 */
public class MyException4 {

    public static void main(String[] args) {

        try {
            method1();
        } catch (MyCustomRuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getERROR_CODE());
        }

        method1(); // 처리 안해도 됨

        /**
         * 내가 만든 예외
         * 100
         * Exception in thread "main" exception.MyException4$MyCustomRuntimeException: 내가 만든 예외
         * 	at exception.MyException4.method2(MyException4.java:26)
         * 	at exception.MyException4.method1(MyException4.java:22)
         * 	at exception.MyException4.main(MyException4.java:18)
         */
    }

    private static void method1() {
        method2();
    }

    private static void method2() throws RuntimeException {
        throw new MyCustomRuntimeException("내가 만든 예외", 100);
    }

    static class MyCustomRuntimeException extends RuntimeException {
        private final int ERROR_CODE;

        public MyCustomRuntimeException(String message, int ERROR_CODE) {
            super(message);
            this.ERROR_CODE = ERROR_CODE;
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }
}
