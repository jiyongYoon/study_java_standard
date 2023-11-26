package iostream;

import java.io.File;
import java.io.IOException;

public class FileBase {

    public static void main(String[] args) throws IOException {
        File file = new File("./src/iostream/test.txt");
        String fileName = file.getName();
        int pos = fileName.lastIndexOf(".");

        System.out.println("경로를 제외한 파일 이름: file.getName() = " + file.getName()); // 경로를 제외한 파일 이름: file.getName() = test.txt
        System.out.println("확장자를 제외한 파일이름: fileName.substring(0, pos) = " + fileName.substring(0, pos)); // 확장자를 제외한 파일이름: fileName.substring(0, pos) = test
        System.out.println("확장자: fileName.substring(pos + 1) = " + fileName.substring(pos + 1)); // 확장자: fileName.substring(pos + 1) = txt

        System.out.println("경로를 포함한 파일이름: file.getPath() = " + file.getPath()); // 경로를 포함한 파일이름: file.getPath() = .\src\iostream\test.txt
        System.out.println("파일의 절대경로: file.getAbsolutePath() = " + file.getAbsolutePath()); // 파일의 절대경로: file.getAbsolutePath() = C:\Users\Yoon jiyong\Desktop\develop\study\java\standard_java\standard\.\src\iostream\test.txt
        System.out.println("파일의 정규경로: file.getCanonicalPath() = " + file.getCanonicalPath()); // 파일의 정규경로: file.getCanonicalPath() = C:\Users\Yoon jiyong\Desktop\develop\study\java\standard_java\standard\src\iostream\test.txt
        System.out.println("파일이 속해 있는 디렉토리: file.getParent() = " + file.getParent()); // 파일이 속해 있는 디렉토리: file.getParent() = .\src\iostream
        System.out.println();

        System.out.println("File.pathSeparator = " + File.pathSeparator); // File.pathSeparator = ;
        System.out.println("File.separator = " + File.separator); // File.separator = \
        System.out.println("File.separatorChar = " + File.separatorChar); // File.separatorChar = \
        System.out.println();

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir")); // System.getProperty("user.dir") = C:\Users\Yoon jiyong\Desktop\develop\study\java\standard_java\standard
        System.out.println("System.getProperty(\"sun.boot.class.path\") = " +
            System.getProperty("sun.boot.class.path")); // System.getProperty("sun.boot.class.path") = null
    }

}
