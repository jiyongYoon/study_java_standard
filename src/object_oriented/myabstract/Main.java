package object_oriented.myabstract;

public class Main {

    public static void main(String[] args) {
        Dropship dropship = new Dropship();

        Marine marine1 = new Marine();
        Marine marine2 = new Marine();
        Marine marine3 = new Marine();
        Marine marine4 = new Marine();

        Tank tank1 = new Tank();
        Tank tank2 = new Tank();

        marine1.move(5, 5);
        marine2.move(5, 3);
        marine3.move(3, 5);
        marine4.move(3, 3);

        tank1.move(3, 3);
        tank2.move(3, 3);

        dropship.move(5, 5);

        dropship.load(tank1);
        dropship.load(tank2);
        dropship.load(marine1);

        dropship.move(3, 3);

        dropship.unload(Marine.class, 1);

        dropship.load(marine1);
        dropship.load(marine2);
        dropship.load(marine3);
        dropship.load(marine4);
        dropship.load(tank1);
        dropship.load(tank2);

        dropship.unload(Marine.class, 4);
        dropship.load(tank2);

        dropship.move(7, 7);
        dropship.unload(Tank.class, 3);

        tank1.changeMode();
        tank1.changeMode();
        tank2.changeMode();
        tank2.changeMode();
    }
}
