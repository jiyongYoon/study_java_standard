package thread;

public class ThreadPriority {

    public static void main(String[] args) {
        // Thread 생성 시 우선순위는 Thread를 생성한 Thread에서 상속받게 된다.
        // main Thread의 기본값은 5이기 때문에, thread4의 priority는 set을 하지 않아도 5가 된다.
        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();

        thread5.setPriority(7);

        System.out.println("thread4(\"-\").getPriority() = " + thread4.getPriority());
        System.out.println("thread5(\"|\").getPriority() = " + thread5.getPriority());

        thread4.start();
        thread5.start(); // 우선순위가 더 높은 | 가 더 빨리 출력작업이 끝나야 하지만, 이는 싱글코어에서 유효하며 멀티 코어에서는 의미가 없었다.
        // ==> 멀티코어라고 해도 OS마다 다른 방식으로 스케쥴링을 하기 때문. (그래서 사실 크게 의미가 없는 작업임..)
    }
}

class Thread4 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int j = 0; j < 10000000; j++) {
                // 시간 지연을 위한 loop
            }
        }
    }
}

class Thread5 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int j = 0; j < 10000000; j++) {
                // 시간 지연을 위한 loop
            }
        }
    }
}
