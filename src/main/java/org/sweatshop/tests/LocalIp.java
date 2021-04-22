package org.sweatshop.tests;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalIp {

    public static void main(String[] args) {
        try {
            String hostIP = InetAddress.getLocalHost().getHostAddress();
            System.out.println(InetAddress.getLocalHost());
            System.out.println(hostIP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
