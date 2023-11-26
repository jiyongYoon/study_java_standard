package iostream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class AboutByteStream {

    public static void main(String[] args) throws IOException {
        /* [ 바이트 기반 스트림 ]
        파일:             FileInputStream - FileOutputStream
        메모리(byte배열):  ByteArrayInputStream - ByteArrayOutputStream
        프로세스(간 통신):  PipedInputStream - PipedOutputStream
        오디오장치:        AudioInputStream - AudioOutputStream
         */

        /* [ 문자 기반 스트림]
        바이트 기반 스트림의 클래스명의 'InputStream' -> 'Reader' / 'OutputStream' -> 'Writer'로 바꿈.
         */

        /* [ 보조 스트림 ] - 실제 데이터를 주고 받는 기능은 없지만, 스트림의 기능을 향상시캐거나 새로운 기능을 추가할 수 있음.
        FilterInput/OutputStream:       필터를 이용한 입출력 처리
        BufferedInput/OutputStream:     버퍼를 이용한 입출력 성능 향상
        DataInput/OutputStream:         int, float와 같은 기본형 단위(primitive type)로 데이터 처리
        SequenceInputStream:            두개의 스트림을 하나로 연결
        LineNumberInputStream:          읽어 온 데이터의 라인 번호를 카운트 (1.1부터 LineNumberReader로 변경됨)
        ObjectInput/OutputStream:       데이터를 객체 단위로 읽고 쓰는데 사용. 주로 파일을 이용하여 객체 직렬화와 관련이 있음.
        PrintStream:                    버터를 이용하여 추가적인 print관련 기능
        PushbackInputStream:            버퍼를 이용해서 읽어 온 데이터를 다시 되돌리는 기능(unread)
         */

        /* 사용: 기반스트림의 파라미터로 넘긴다.
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read();
         */

        // Input, Output 예제
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc); // inSrc 데이터를 임시로 바이트 배열로 input에 담아서 다른 작업을 함.
        output = new ByteArrayOutputStream();

        int data = 0;
        int targetInt = -1; // 만약 targetInt가 중간의 어떤 값이라면, InputStream에 나머지 값은 남아있게 된다.

        // read() 에서 호출한 반한괎을 변수 data에 저장하고, -1이랑 같은지 확인 -> 즉, 끝까지 다 출력받기 위함.
        while ((data = input.read()) != targetInt) {
            output.write(data);
        }

        /* 이렇게 하면 한번에 배열을 이용해서 옮겨 담은 후, 그 배열의 크기만큼 읽고 쓸 수 있게 된다. 작업 효율이 늘어난다는 뜻.
        byte[] temp = new byte[inSrc.length];
        input.read(temp, 0, temp.length);
        output.write(temp);
         */

        outSrc = output.toByteArray();

        System.out.println("Input Source      : " + Arrays.toString(inSrc));
        System.out.println("Output Source     : " + Arrays.toString(outSrc));

        System.out.println("데이터 전달 후 InputStream     : " + Arrays.toString(input.readAllBytes())); // input.read를 통해 stream 데이터를 모두 읽었기 때문에 남은 데이터가 없다.
    }

}
