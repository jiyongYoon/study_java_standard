package exception;

public class ExceptionReThrowing {

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("main 메서드에서 예외가 처리되었습니다.");
        }
        /**
         * method1 메서드에서 예외가 처리되었습니다.
         * main 메서드에서 예외가 처리되었습니다.
         */
    }

    static void method1() throws Exception { // re-throwing
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("method1 메서드에서 예외가 처리되었습니다.");
            throw e;
        }
    }

}
