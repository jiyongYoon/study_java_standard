package thread;

/**
 * [Thread]
 * 쓰레드를 구현하는 2가지 방법
 * 1. Thread 클래스 상속
 * 2. Runnable 인터페이스 구현
 * 다른 차이는 없지만, Thread 클래스는 상속을 받으면 다른 클래스를 상속받을 수 없다는 단점이 존재한다.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();

        Runnable runnable = new Thread2();
        Thread thread2 = new Thread(runnable); // Thread 생성자의 파라미터에 Runnable

        thread1.start();
        thread2.start();
        // 쓰레드의 실행순서는 OS의 스케쥴러가 작성한 스케쥴에 의해 결정된다.

        /* [call stack]
        1. main 쓰레드에서 start 메서드가 호출되면 새로운 쓰레드를 생성한다.

        [   start    ] ----->  new Thread
        [    main    ]
        [ main 쓰레드 ]

        2. 새로운 쓰레드에서 run 메서드가 실행된다. main 쓰레드의 start는 run 호출 후 스택에서 사라진다.

        [    start   ] |
        [    main    ] | [     run    ]
        [ main 쓰레드 ] | [ new 쓰레드 ]

        3. 이제는 두 호출 스텍에서 OS의 소케쥴러가 정한 순서대로 번갈아가면서 실행된다.

        [    main    ] | [     run    ]
        [ main 쓰레드 ] | [ new 쓰레드 ]
         */
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); // 조상 Thread의 getName() 메서드 호출
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
