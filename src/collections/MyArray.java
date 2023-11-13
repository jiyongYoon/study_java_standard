package collections;

import java.util.Arrays;

/** [배열]
 * 데이터가 메모리 상에 연속적으로 저장됨.
 * 인덱스와 1:1 대응.
 * - 장점: 데이터에 빠르게 접근이 가능함.
 * - 단점: 데이터의 추가/삭제가 번거로움. (미리 최대 길이를 정해서 생성해야함, 만약 크기를 변경할 필요가 있으면 새로운 배열을 생성해야함)
 * +ㅡㅡㅡ 데이터 삭제 시, 인덱스를 유지하기 위해 빈 공간을 유지한다.
 */
public class MyArray {

    int[] arr;

    MyArray(int size) {
        this.arr = new int[size];
    }

    // 배열의 데이터 삽입
    public void insertData(int index, int data) {
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }

    // 배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIdx = -1;

        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == data) {
                targetIdx = i;
                break;
            }
        }

        if (targetIdx == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIdx; i++) {
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIdx; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }

    public static void main(String[] args) {
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insertData(-1, 0);

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(99);
    }
}
