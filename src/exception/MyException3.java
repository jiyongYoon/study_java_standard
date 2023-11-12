package exception;

public class MyException3 {

    public static void main(String[] args) {
        try {
            method1();
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getERROR_CODE());
        }
    }

    private static void method1() throws MyCustomException {
        method2();
    }

    private static void method2() throws MyCustomException {
        throw new MyCustomException("내가 만든 예외~", 100);
    }
    /** main 메서드에서 그냥 throws Exception 을 하면
     * Exception in thread "main" exception.MyException3$MyCustomException: 내가 만든 예외~
     * 	at exception.MyException3.method2(MyException3.java:14) <- 마지막 call stack: Exception이 생긴 메서드
     * 	at exception.MyException3.method1(MyException3.java:10) <- 그 다음 call stack
     * 	at exception.MyException3.main(MyException3.java:6) <- 맨 처음 call stack
     */

    /** try - catch로 감싸면
     * 내가 만든 예외~
     * 100
     */

    static class MyCustomException extends Exception {
        private int ERROR_CODE;
        MyCustomException(String msg) {
            super(msg);
            this.ERROR_CODE = 100;
        }

        public MyCustomException(String msg, int ERROR_CODE) {
            this(msg);
            this.ERROR_CODE = ERROR_CODE;
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }

}
