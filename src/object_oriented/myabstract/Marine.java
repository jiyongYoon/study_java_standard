package object_oriented.myabstract;

public class Marine extends Unit {

    public Marine() {
        health = 50;
        capacity = CAPACITY.MARINE;
    }

    @Override
    void hello() {
        System.out.println("해병: 명령을 내려주십시오!");
    }

    @Override
    void move(int x, int y) {
        super.move(x, y);
        System.out.println("마린이 움직입니다, " + getPoint(x, y));
    }

    void stimPack() {
        if (health > 10) {
            health -= 10;
            System.out.println("스팀팩을 사용합니다, 남은 체력: " + this.health);
        } else {
            System.out.println("스팀팩을 사용할 수 없습니다.");
        }
    }
}
