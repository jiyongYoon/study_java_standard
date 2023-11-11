package object_oriented.myabstract;

public abstract class Unit {

    public Unit() {
        hello();
    }

    CAPACITY capacity;
    int health;
    int x, y;
    abstract void hello();
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    };
    void stop() {
        System.out.println("현재 위치에 정지, " + getPoint(x, y));
    };

    String getPoint(int x, int y) {
        return "(" + x + ", " + y + ")";
    }

}
