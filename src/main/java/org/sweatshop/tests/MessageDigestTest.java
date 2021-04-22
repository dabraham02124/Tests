package org.sweatshop.tests;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDigestTest {

    private final static String s = "Hello";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] byteData = md.digest(s.getBytes());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());
    }

    public class MySha256MessageDigest {
        private final MessageDigest md = getInstance();

        public byte[] digest() { return md.digest(); }
        public byte[] digest(String s) { return md.digest(s.getBytes()); }
        public byte[] digest(byte[] b) { return md.digest(b); }

        public void update(String s) { md.update(s.getBytes()); }
        public void update(byte[] b) { md.update(b); }

        private MessageDigest getInstance() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                log.error("can't happen, no SHA-256 algorithm", e);
            }
            return null;
        }
    }
}
