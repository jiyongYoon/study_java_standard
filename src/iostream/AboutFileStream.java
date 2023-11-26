package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream으로 data를 Copy한 후, FileOutputStream으로 새로운 File로 출력하여 만듦. <br>
 * 텍스트 파일을 다룬다면 Stream보다 Reader/Writer를 사용하는 것이 더 좋다.
 */
public class AboutFileStream {

    public static void main(String[] args) {

        String copyTargetFileName = "./src/iostream/AboutFileStream.java";
        String copyFileName = "./src/iostream/AboutFileStream_copy.bak";

        try {
            FileInputStream fis = new FileInputStream(copyTargetFileName);
            FileOutputStream fos = new FileOutputStream(copyFileName);

            int data = 0;
            // 한 바이트씩 읽게 되므로 속도가 느린데, 이것을 보완하기 위해서 BufferedStream을 사용할 수 있다.
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
