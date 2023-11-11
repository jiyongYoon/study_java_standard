package object_oriented.myabstract;

public class Tank extends Unit {

    public Tank() {
        health = 150;
        capacity = CAPACITY.TANK;
    }

    boolean siege;

    @Override
    void hello() {
        System.out.println("탱크: 어디를 부수러 갈까?!");
    }

    @Override
    void move(int x, int y) {
        super.move(x, y);
        System.out.println("탱크가 움직입니다, " + getPoint(x, y));
    }

    void changeMode() {
        this.siege = !this.siege;
        System.out.println("탱크가 모드를 변경합니다, " + getMode());
    }

    String getMode() {
        if (this.siege) return "시즈모드";
        else return "일반모드";
    }
}
