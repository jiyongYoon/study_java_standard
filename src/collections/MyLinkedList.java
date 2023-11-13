package collections;

/** [연결리스트]
 * 자료의 순서는 정해져있지만, 메모리상 연속성은 보장되지는 않음.
 * - 장점: 데이터 공간을 미리 할당할 필요가 없으며, 리스트 길이가 가변적이라 데이터 추가/삭제가 용이함
 * - 단점: 연결구조를 위한 별도 데이터 공간이 필요하며, 연결 정보를 찾는 시간이 필요하여 접근 속도가 배열에 비해 느린 편. 데이터 추가 삭제시 연결구성을 다시 해주어야함.
 */

class Node {
    int data;
    Node next;

    Node() {}
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class MyLinkedList {

    Node head;

    public MyLinkedList() {
    }

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node prev = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new Node(data, this.head);
                    } else {
                        prev.next = new Node(data, cur) ;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;
        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(new Node(1, null));
        myLinkedList.showData();

        myLinkedList.addData(2);
        myLinkedList.addData(3);
        myLinkedList.addData(4);
        myLinkedList.addData(6);
        myLinkedList.addData(7);
        myLinkedList.addData(5, 6);
        myLinkedList.showData();

        myLinkedList.findData(3);
        myLinkedList.findData(100);

        myLinkedList.removeData(2);
        myLinkedList.removeData(4);
        myLinkedList.showData();

        myLinkedList.removeData(3);
        myLinkedList.removeData(5);
        myLinkedList.removeData(1);
        myLinkedList.removeData();
        myLinkedList.showData();
    }
}


