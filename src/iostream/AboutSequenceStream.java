package iostream;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

/**
 * 여러개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로 만듦
 */
public class AboutSequenceStream {

    public static void main(String[] args) throws IOException {
        Vector files = new Vector();
        files.add(new FileInputStream("./src/iostream/123.txt"));
        files.add(new FileInputStream("./src/iostream/AboutFileStream_copy.bak"));

        SequenceInputStream in = new SequenceInputStream(files.elements());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int data = 0;

        while ((data = in.read()) != -1) {
            out.write(data);
        }

        System.out.println("Output Stream: " + Arrays.toString(out.toByteArray()));
    }

}
