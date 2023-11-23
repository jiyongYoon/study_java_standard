package collections;


/**
 * key 값을 Hash Function을 통해서 Hash Value를 만들어 index로 사용하는 테이블 <br>
 * key --function-> { HashValue : RealValue }
 *
 * function으로 얻은 HashValue도 결국 겹치게 되어있는데, 이 때 여러 방법들로 해결함. <br>
 * 1) 개방 주소법: 가까운 곳의 빈 공간에 데이터를 적재하는 개념 (선형탐사법, 제곱탐사법, 이중해싱)
 * 2) 분리 연결볍: 새로운 인덱스를 찾는것이 아니라, 기존 인덱스에 연결리스트를 이용하여 데이터를 적재하는 개념.
 */
public class MyHashTable {

    Integer[] table;
    int elemCnt;

    public MyHashTable() {}
    public MyHashTable(int size) {
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elemCnt++;
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key) {
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i + ": " + this.table[i]);
        }
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(7);
        hashTable.setValue(1, 1);
        hashTable.setValue(2, 2);
        hashTable.setValue(3, 3);
        hashTable.setValue(4, 4);
        hashTable.setValue(5, 5);
        hashTable.printHashTable();
        /*
        == Hash Table ==
        0: null
        1: 1
        2: 2
        3: 3
        4: 4
        5: 5
        6: null
         */
        hashTable.setValue(8, 6); // 해시 충돌 발생
        hashTable.printHashTable();
        /*
        == Hash Table ==
        0: null
        1: 6
        2: 2
        3: 3
        4: 4
        5: 5
        6: null
         */
    }
}
