package org.sweatshop.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;

public class RuntimeTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        String s = "\"foo\" said bar";
        System.out.println(s);
        s = s.replaceAll("\"", "\\\\\"");
        System.out.println(s);

        Process pr = Runtime.getRuntime().exec(new String[] {"wc","-l","pom.xml"});
        if (pr.waitFor(120, TimeUnit.SECONDS)) {
            System.out.println(pr.exitValue());
            System.out.println(streamToStrings(pr.getInputStream()));
        }
    }

    @SneakyThrows
    private static String streamToStrings(InputStream stream) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

}
