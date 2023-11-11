### 다형성
다형성을 공부하던 중, 형변환과 변수 및 메서드 접근에 대한 궁금증이 생겼다.

상황을 간단하게 코드로 확인해보자.

- 부모 클래스
```java
class Parent {
    
    void test() {
        System.out.println("부모 클래스");
    }
}
```

- 자식 클래스
```java
class Child extends Parent {
    
    @Override
    void test() {
        System.out.println("자식 클래스");
    }
    
    void test2() {
        System.out.println("자식 클래스만");
    }
}
```

두 클래스의 인스턴스를 만들고, 형변환을 하여 어느 메서드가 접근 가능한지 확인해보면

```java
class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.test();
        
        Child child = new Child();
        child.test();
        child.test2();
    }
}
```

여기까지는 무난하나 형변환이 되면

```java
class Main {

    public static void main(String[] args) {
        Parent polyChild = new Child();
        polyChild.test();
        polyChild.test2(); // 호출 불가
        
        Child castingPolyChild = (Child) polyChild;
        castingPolyChild.test();
        castingPolyChild.test2(); // 호출 가능

        System.out.println(polyChild); // 객체 주소값 동일
        System.out.println(castingPolyChild); // 객체 주소값 동일
    }
}
```

분명히 같은 주소값을 가지고 있는데, 호출 가능한 메서드(변수)가 달라진다.

### 원인
원인은 바로 컴파일러 때문이었다.
컴파일러가 인스턴스의 변수 및 메서드에 접근할 떄, 접근 가능한 범위를 변수의 타입을 보고 판단하기 때문이라고 한다.
즉, `polyChild`의 타입은 `Parent`이기 때문에, 컴파일러는 이 인스턴스는 `Parent`와 동일한 접근범위를 가진다고 판단한다는 뜻이다.

> 자바의 객체 지향 프로그래밍에서 변수의 타입은 컴파일 시점에 결정되며, 이를 "정적 타입"이라고 합니다. 정적 타입은 변수가 어떤 클래스의 인스턴스를 참조하고 있는지를 컴파일러가 미리 알 수 있게 합니다. 이러한 특성은 메모리 할당과 메서드 호출에 영향을 미칩니다. <br> <br> 
> 다음은 메모리 동작과 연관된 간단한 설명입니다: <br> <br>
> **메모리 할당:**  <br> 
> 객체가 메모리에 할당될 때, 해당 객체의 실제 타입에 따라 필요한 메모리 공간이 할당됩니다. 즉, 자식 클래스의 객체가 생성되면 자식 클래스에 해당하는 메모리 크기가 할당됩니다. <br> <br> 
> **참조 변수와 다형성:** <br> 
> 부모 클래스 타입의 변수가 자식 클래스의 객체를 참조할 경우, 해당 객체의 주소가 참조 변수에 저장됩니다. 이때, 변수의 정적 타입은 부모 클래스이지만, 실제 가리키는 객체의 타입은 자식 클래스입니다. 이것이 다형성의 한 예시입니다. <br> <br> 
> **컴파일러의 타입 체크:**  <br>
> 컴파일러는 변수의 정적 타입을 기반으로 코드를 분석합니다. 따라서 부모 클래스로 선언된 변수는 컴파일러가 부모 클래스의 멤버만 접근 가능하다고 간주하며, 자식 클래스의 추가된 메서드 또는 멤버에는 접근할 수 없다고 판단합니다.  <br> <br>
> **런타임 다형성:** <br>
> 실제 실행 시(runtime), 프로그램은 객체의 실제 타입을 기반으로 메서드를 호출합니다. 따라서 객체가 자식 클래스의 인스턴스인 경우, 실제로 자식 클래스의 메서드가 호출됩니다.  <br> <br>
> 이러한 정적 타입과 런타임 다형성의 조합으로 인해 부모 클래스 타입의 변수에 자식 클래스의 객체를 할당했을 때, 컴파일러는 해당 변수를 부모 클래스의 멤버에만 접근할 수 있다고 인식하게 됩니다. 따라서 컴파일 시에는 부모 클래스의 멤버에만 접근 가능하다는 제한이 발생하며, 이는 객체 지향 프로그래밍의 다형성을 이해하고 활용하는 중요한 개념 중 하나입니다.  <br> <br>
> I am GPT에요







