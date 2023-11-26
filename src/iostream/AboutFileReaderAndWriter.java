package iostream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 문자기반의 스트림인 Reader/Writer는 byte[] 배열 대신 char[] 배열을 사용한다는 점만 다르다.
 */
public class AboutFileReaderAndWriter {

    public static void main(String[] args) {
        try {
            String fileName = "./src/iostream/test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;
            // FileInputStream으로 파일을 읽음
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            // ìëíì¸ì => 한글 출력 깨짐
            System.out.println();
            fis.close();

            // FileReader로 파일을 읽음
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            // 안녕하세요 => 한글 출력 잘됨
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
