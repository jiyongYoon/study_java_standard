package exception;

public class ChainedException {

    public static void main(String[] args) {
        try {
            System.out.println("인스톨 시작");
            install(); // 이 메서드 안에서의 finally 까지 마치고 catch로 나옴.
        } catch (InstallException e) {
            System.out.println("인스톨 예외 발생");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("예외 발생");
            e.printStackTrace();
        } finally {
            System.out.println("프로그램 종료");
        }
        /**
         * 인스톨 시작
         * 임시 파일들을 삭제한다.
         * 인스톨 예외 발생
         * 프로그램 종료
         * exception.ChainedException$InstallException: 설치 중 예외 발생
         * 	at exception.ChainedException.install(ChainedException.java:22)
         * 	at exception.ChainedException.main(ChainedException.java:8)
         * Caused by: exception.ChainedException$SpaceException2: 설치 공간이 부족합니다.
         * 	at exception.ChainedException.startInstall(ChainedException.java:37)
         * 	at exception.ChainedException.install(ChainedException.java:20)
         * 	... 1 more
         */
    }

    static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException2 | MemoryException2 ce) {
            InstallException ie = new InstallException("설치 중 예외 발생"); // 새로 던질 예외
            ie.initCause(ce); // 원인 추가
            throw ie; // 예외 던짐
        } finally {
            deleteTempFiles();
        }

    }

    static void startInstall() throws SpaceException2, MemoryException2 {
        if (!enoughSpace()) {
            throw new SpaceException2("설치 공간이 부족합니다.");
        }

        if (!enoughMemory()) {
            throw new MemoryException2("메모리가 부족합니다.");
        }
    }

    static void copyFiles() {
        System.out.println("파일을 복사한다.");
    }

    static void deleteTempFiles() {
        System.out.println("임시 파일들을 삭제한다.");
    }

    static boolean enoughSpace() {
        // 공간 확인 후 부족하다고 가정하고
        return false;
    }

    static boolean enoughMemory() {
        // 메모리 확인 후 충분하다고 가정하고
        return true;
    }

    static class InstallException extends Exception {

        public InstallException(String message) {
            super(message);
        }
    }

    static class SpaceException2 extends Exception {

        public SpaceException2(String message) {
            super(message);
        }
    }

    static class MemoryException2 extends Exception {

        public MemoryException2(String message) {
            super(message);
        }
    }

}
