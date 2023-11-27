package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("ip.getHostName() = " + ip.getHostName()); // ip.getHostName() = www.naver.com
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress()); // ip.getHostAddress() = 223.130.195.95
            System.out.println("ip.toString() = " + ip.toString()); // ip.toString() = www.naver.com/223.130.195.95

            byte[] ipAddr = ip.getAddress();
            System.out.println("Arrays.toString(ipAddr) = " + Arrays.toString(ipAddr)); // Arrays.toString(ipAddr) = [-33, -126, -61, 95]

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0 ? ipAddr[i] + 256 : ipAddr[i]) + ".";
                System.out.println("getAddress()+256: " + result); // getAddress()+256: 223., getAddress()+256: 223.130.195., getAddress()+256: 223.130.195.95.
                System.out.println();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("ip.getHostName() = " + ip.getHostName()); // ip.getHostName() = Yoon-GalaxyBook
            System.out.println("ip.getHostAddress() = " + ip.getHostAddress()); // ip.getHostAddress() = 192.168.0.2
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr["+i+"] = " + ipArr[i]); // ipArr[0] = www.naver.com/223.130.195.95, ipArr[1] = www.naver.com/223.130.200.104
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
