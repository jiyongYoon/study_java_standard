package exception;

public class MyException1 {

    public static void main(String[] args) {
        System.out.println(1);
        try {
            System.out.println(2);
            System.out.println(0/0);
            System.out.println(3);
        } catch (ArithmeticException ae) {
            ae.printStackTrace();
            System.out.println("ArithmeticException, " + ae.getMessage());
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(4);
    }
    /**
     * 1
     * 2
     * java.lang.ArithmeticException: / by zero
     * 	at exception.MyException1.main(MyException1.java:9)
     * ArithmeticException, / by zero
     * 4
     */
}
