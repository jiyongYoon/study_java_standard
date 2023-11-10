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
    int i;

    @Override
    public String toString() {
        return "InitializationBlock{" +
            "str='" + str + '\'' +
            ", i=" + i +
            '}';
    }

    public static void main(String[] args) {
        System.out.println(staticStr);

        InitializationBlock initializationBlock1 = new InitializationBlock();
        System.out.println(initializationBlock1);

        InitializationBlock initializationBlock2 = new InitializationBlock();
        System.out.println(initializationBlock2);

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
