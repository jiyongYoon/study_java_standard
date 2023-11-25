package thread;

public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable1();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);
        thread1.start();
        thread2.start(); // ThreadGroup에 의해 참조되므로 gc 대상이 아니다.
        /**
         * balance: 500
         * balance: 500
         * balance: 200
         * balance: 100
         * balance: 0
         * balance: -100 -> withdraw 메서드에서 if문의 balance -= money 가 되기 전에 다른 쓰레드가 if문에 진입했기 때문에 잔고가 음수가 되어버림
         */
        thread1.join();
        thread2.join();

        System.out.println("----------------------");

        Runnable runnable2 = new Runnable2();
        new Thread(runnable2).start();
        new Thread(runnable2).start();
        /**
         * balance: 700
         * balance: 600
         * balance: 500
         * balance: 400
         * balance: 100
         * balance: 100
         * balance: 0
         * balance: 0
         */
    }


}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            balance -= money;
        }
    }

    public synchronized void withdrawSynchro(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            balance -= money;
        }
    }
}

class Runnable1 implements Runnable {

    Account account = new Account();

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance: " + account.getBalance());
        }
    }
}

class Runnable2 implements Runnable {

    Account account = new Account();

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdrawSynchro(money);
            System.out.println("balance: " + account.getBalance());
        }
    }
}
