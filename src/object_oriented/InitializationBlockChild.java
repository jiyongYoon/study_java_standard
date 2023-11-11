package object_oriented;

public class InitializationBlockChild extends InitializationBlock {

    {
        System.out.println("이 블럭은 자식 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.");
        str = "자식인스턴스변수 초기화";
    }

    String str;

    void print() {
        System.out.println("print() 메서드 실행---");
        System.out.println(this.getStringMe());
    }

    void printStr() {
        System.out.println("printStr() 메서드 실행---");
        System.out.println("super.str = " + super.str);
        System.out.println("this.str = " + this.str);
    }

    @Override
    void test() {
        System.out.println("이것은 자식의 test() 메서드다.");
    }

    public static void main(String[] args) {
        InitializationBlockChild child = new InitializationBlockChild();
        child.print();
        child.printStr();

        /** [console]
         * 이 블럭은 static { } 블럭으로, 클래스가 초기화 될 때 실행되는 코드 블럭입니다.
         * 이 블럭은 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.
         * 이 블럭은 자식 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.
         * print() 메서드 실행---
         * InitializationBlock{str='인스턴스변수 초기화', i=2}
         * printStr() 메서드 실행---
         * super.str = 인스턴스변수 초기화
         * this.str = 자식인스턴스변수 초기화
         *
         * 상속된 클래스의 인스턴스를 만들 경우, 부모의 인스턴스가 생성되고, 자식의 인스턴스가 생성된다.
         * 그리고 부모의 인스턴스 변수 및 인스턴스 메서드에 접근할 수 있게 된다.
         * (단, 생성자와 초기화 블럭은 자식 인스턴스에서 사용이 불가능하다. 생성자는 super 키워드로 접근해야함.)
         */

        InitializationBlock polymorphismChild = new InitializationBlockChild();
//        polymorphismChild.print(); // 자식 인스턴스를 부모 타입으로 담는건 가능하지만, 자식 인스턴스의 메서드는 사용하지 못한다.
//        polymorphismChild.printStr();


        // 형변환
        InitializationBlockChild castingPolymorphismChild = (InitializationBlockChild) polymorphismChild;
        castingPolymorphismChild.print();
        castingPolymorphismChild.printStr();

        // 형변환이 되기 전과 된 후의 인스턴스 주소값 자체는 같다.
        System.out.println(polymorphismChild); // object_oriented.InitializationBlockChild@3f2a3a5
        System.out.println(castingPolymorphismChild); // object_oriented.InitializationBlockChild@3f2a3a5
        // Q. 그럼 왜 주소값이 같은데 부모타입의 변수로 바뀌었다고 메서드를 못쓰는 것일까?
        // A. 간단 결론: 컴파일러는 변수의 타입(부모타입)으로 변수 및 메서드 접근 가능여부를 판단하기 때문이라고 함.
        polymorphismChild.test(); // 이것은 자식의 test() 메서드다.
        castingPolymorphismChild.test(); // 이것은 자식의 test() 메서드다.

        System.out.println(polymorphismChild instanceof InitializationBlock); // true
        System.out.println(polymorphismChild instanceof InitializationBlockChild); // true
        System.out.println(castingPolymorphismChild instanceof InitializationBlock); // true
        System.out.println(castingPolymorphismChild instanceof InitializationBlockChild); // true

        InitializationBlock initializationBlock = new InitializationBlock();

        System.out.println(initializationBlock instanceof InitializationBlock); // true
        System.out.println(initializationBlock instanceof InitializationBlockChild); // false

    }
}
