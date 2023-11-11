package object_oriented.myabstract;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Dropship extends Unit {

    List<Unit> space = new CopyOnWriteArrayList<>();

    final int MAX_CAPACITY = 8;

    int currentCapa;

    public Dropship() {
        health = 125;
    }


    @Override
    void hello() {
        System.out.println("수송선: 인더바이~ 바이바이바이~");
    }

    @Override
    void move(int x, int y) {
        super.move(x, y);
        System.out.println("드랍십이 움직입니다, " + getPoint(x, y));
    }

    void load(Unit unit) {
        if (unit.x != this.x || unit.y != this.y) {
            System.out.println("현재 위치에 유닛이 없습니다.");
            return;
        }

        int unitCapa = unit.capacity.getCapacity();
        if (getRemain() - unitCapa >= 0) {
            space.add(unit);
            currentCapa += unit.capacity.getCapacity();
            System.out.println("유닛을 태웁니다, 남은공간: " + getRemain());
        } else {
            System.out.println("남은 공간이 없어서 태울 수 없습니다.");
        }
    }

    void unload(Class<? extends Unit> unitClass, int count) {
        if (space.isEmpty()) {
            System.out.println("유닛이 없습니다.");
        } else {
            for (Unit unit1 : space) {
                if (count > 0 && unit1.getClass().equals(unitClass)) {
                    count--;
                    space.remove(unit1);
                    this.currentCapa -= unit1.capacity.getCapacity();
                    System.out.println("유닛을 내립니다, 남은 공간: " + getRemain());
                    unit1.move(this.x, this.y);
                } else {
                    System.out.println("내리려는 유닛이 없습니다.");
                }
            }
        }
    }

    void unloadAll() {
        if (space.isEmpty()) {
            System.out.println("유닛이 없습니다.");
        } else {
            for (Unit unit : space) {
                this.currentCapa -= unit.capacity.getCapacity();
                System.out.println("유닛을 내립니다, 남은 공간: " + getRemain());
                unit.move(this.x, this.y);
            }
            System.out.println("모든 유닛을 내렸습니다.");
        }
    }

    int getRemain() {
        return MAX_CAPACITY - this.currentCapa;
    }
}
