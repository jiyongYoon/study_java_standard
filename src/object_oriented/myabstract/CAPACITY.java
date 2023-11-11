package object_oriented.myabstract;

public enum CAPACITY {
    MARINE(1),
    TANK(4)
    ;

    final int capacity;

    CAPACITY(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
