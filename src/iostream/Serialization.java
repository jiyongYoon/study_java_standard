package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** [ 직렬화 / 역직렬화 ]
 * 객체를 데이터 스트림으로 만드는 것을 뜻한다. 즉, 객체에 저장된 데이터를 스트림에 쓰기(write) 위해 연속적인(serial) 데이터로 변환하는 것을 말한다. <br>
 * 사실, 객체를 저장하거나 전송하려면 당연히 이렇게 할 수 밖에 없다. <br>
 * 객체는 클래스에 정의된 인스턴스변수의 집합이다. (메서드는 모든 인스턴스마다 같은 내용의 코드를 포함시킬 필요가 없기 때문에 객체마다 저장하지 않는다.) <br>
 * 그래서 객체를 저장한다는 것은 객체의 모든 인스턴스 변수값을 저장한다는 뜻이다.
 */
public class Serialization {

    public static void main(String[] args) {
        try {
            String fileName = "./src/iostream/UserInfo.ser"; // ser: 직렬화의 약자 컨벤션

            FileOutputStream fos = new FileOutputStream(fileName);

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
            UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);

            List<UserInfo> userInfoList = new ArrayList<>(Arrays.asList(u1, u2));

            // 객체를 직렬화한다.
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(userInfoList);
            out.close();
            System.out.println("직렬화가 잘 끝났습니다.");
            System.out.println("직렬화하여 저장된 파일을 객체로 출력합니다.");

            FileInputStream fis = new FileInputStream(fileName);

            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream in = new ObjectInputStream(bis);

            // 객체를 읽을때는 출력한 순서와 일치하도록
            UserInfo u3 = (UserInfo) in.readObject();
            UserInfo u4 = (UserInfo) in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println(u3);
            System.out.println(u4);
            System.out.println(list);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

/**
 * Serializable 클래스: 직렬화를 고려하여 작성한 클래스인지를 마킹하기 위한 빈 껍데기 인터페이스
 */
class UserInfo implements Serializable {
    String name;
    transient String password; // transient: 직렬화 대상에서 제외
    int age;

    public UserInfo() {
        this("Unknown", "1111", 0);
    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            '}';
    }
}