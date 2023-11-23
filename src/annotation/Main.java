package annotation;

import java.lang.annotation.Annotation;

public class Main {
    /**
     * 어노테이션은 컴파일러에게 유용한 정보를 제공하기 위해 사용한다. 코드에는 전혀 영향이 없다. <br>
     * 메타어노테이션은 어노테이션의 어노테이션. 즉, 어노테이션을 위한 어노테이션이다. <br>
     * 대표적으로 아래와 같은 것들이 있다.
     * @Target      적용가능한 대상을 지정한다. TYPE(클래스, 인터페이스, enum), METHOD(메서드), FIELD(필드), CONSTRUCTOR(생성자) 등이 대표적이다.
     * @Retention   어노테이션이 유지되는 범위를 지정한다. CLASS가 디폴트값이며, 클래스 파일에 존재하고 실행시에 사용 불가하다. RUNTIME은 실행시에도 사용이 가능하다. 때문에 스프링부트 어노테이션들은 대부분 RUNTIME을 필요로 한다.
     * @Document    정보가 javadoc으로 작성된 문서에 포함되게 한다
     * @Inherited   어노테이션 정보가 자손 클래스에 상속되도록 한다
     * @Repeatable  어노테이션을 반복해서 적용할 수 있게 한다
     */

    public static void main(String[] args) {
        Class<AnnotationTest> cls = AnnotationTest.class;
        Annotation[] annotations = cls.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println("annotation.toString() = " + annotation.toString()); // @annotation.TestInfo(testType=FINAL, count=3, testedBy="Jiyong", testTools={"JUnit", "AutoTester"}, testDate=@annotation.DateTime(yymmdd="230104", hhmmss="124030"))
            System.out.println("annotation.hashCode() = " + annotation.hashCode()); // -261627564
            System.out.println("annotation.equals(annotation) = " + annotation.equals(annotation)); // true
            System.out.println("annotation.annotationType() = " + annotation.annotationType()); // interface annotation.TestInfo
        }
    }
}
