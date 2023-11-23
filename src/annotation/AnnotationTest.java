package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo {
    int count();
    String testedBy();
    String[] testTools();
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

enum TestType {
    FIRST, FINAL
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

@TestInfo(count = 3, testedBy = "Jiyong", testTools = {"JUnit", "AutoTester"}, testType = TestType.FINAL, testDate = @DateTime(yymmdd = "230104", hhmmss = "124030"))
public class AnnotationTest {
}