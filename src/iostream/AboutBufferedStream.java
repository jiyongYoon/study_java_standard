package iostream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInput/OutputStream 의 경우에는, 1 바이트씩 읽고 쓰는 작업이라 상대적으로 느리다. 이를 보완하기 위해 보조 스트림인 BufferedStream을 사용할 수 있다.
 */
public class AboutBufferedStream {

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/iostream/123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // 버퍼 크기를 5로 한다는 뜻

            // 123.txt에 1 부터 9 까지 출력한다. 버퍼 크기가 5이기 때문에 12345는 출력이 되지만, 6789는 출력이 안되고 끝난다.
            for (int i = 1; i < 9; i++) {
                bos.write(i);
            }

//            fos.close(); // FileStream을 닫아주었기 때문에 버퍼에 남아있는 데이터는 출력되지 못한 상태로 프로그램이 종료되어 있다.
            bos.close(); // 이렇게 버퍼를 닫아주어야 나머지 6789도 출력이 되며, FileStream은 따로 닫아주지 않아도 된다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
