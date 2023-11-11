package object_oriented;

public class InitializationBlock {

    static {
        System.out.println("이 블럭은 static { } 블럭으로, 클래스가 초기화 될 때 실행되는 코드 블럭입니다.");
        staticStr = "클래스변수 초기화";
    }

    {
        System.out.println("이 블럭은 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.");
        str = "인스턴스변수 초기화";
        i = 1;
    }

    static String staticStr;
    String str;
    private int i; // 외부 클래스에서 해당 변수에 접근이 불가능함. 때문에 getter, setter와 같은 메서드를 추가로 구현하여 접근하도록 함.

    String getStringMe() {
        return "InitializationBlock{" +
            "str='" + str + '\'' +
            ", i=" + i +
            '}';
    }

    void test() {
        System.out.println("이것은 부모의 test() 메서드다.");
    }

    public static void main(String[] args) {
        System.out.println(staticStr);

        InitializationBlock initializationBlock1 = new InitializationBlock();
        System.out.println(initializationBlock1.getStringMe());

        InitializationBlock initializationBlock2 = new InitializationBlock();
        System.out.println(initializationBlock2.getStringMe());

        /** [console]
         * 이 블럭은 static { } 블럭으로, 클래스가 초기화 될 때 실행되는 코드 블럭입니다.
         * 클래스변수 초기화
         * 이 블럭은 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.
         * InitializationBlock{str='인스턴스변수 초기화', i=1}
         * 이 블럭은 { } 블럭으로, 인스턴스가 초기화 될 때 실행되는 코드 블럭입니다.
         * InitializationBlock{str='인스턴스변수 초기화', i=1}
         *
         * 클래스 초기화 코드블럭은 1번만 실행되지만, 인스턴스 초기화 코드블럭은 인스턴스가 생성될때마다 실행됨.
         */
    }
}
