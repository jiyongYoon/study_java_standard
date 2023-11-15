package date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now()); // 현재 로컬 컴퓨터의 날짜와 시간. 2023-11-15T21:57:53.283479200

        System.out.println(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        System.out.println(LocalDateTime.now(ZoneId.of("America/Los_Angeles")));

        System.out.println(LocalDateTime.of(2023, 11, 15, 1, 2, 3, 4)); // 2023-11-15T01:02:03.000000004

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(now.format(format1)); // 20231115220305938
        System.out.println(now.format(format2)); // 2023-11-15 22:03:05
        System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE)); // 20231115
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2023-11-15T22:03:35.024801
        System.out.println(now.format(DateTimeFormatter.ISO_DATE)); // 2023-11-15
        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2023-11-15
    }

}
