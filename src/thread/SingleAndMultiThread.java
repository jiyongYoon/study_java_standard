package thread;

public class SingleAndMultiThread {
    static long startTime = 0;

    public static void main(String[] args) {
        System.out.println("--------------Single-Thread----------------");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1: " +
            (System.currentTimeMillis() - SingleAndMultiThread.startTime));

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간2: " +
            (System.currentTimeMillis() - SingleAndMultiThread.startTime));

        System.out.println();
        System.out.println();
        System.out.println("--------------Multi-Thread----------------");

        Thread3 thread3 = new Thread3();
        thread3.start();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }

        System.out.print("소요시간1: " +
            (System.currentTimeMillis() - SingleAndMultiThread.startTime));
    }
}

class Thread3 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }

        System.out.print("소요시간2: " +
            (System.currentTimeMillis() - SingleAndMultiThread.startTime));
    }
}
