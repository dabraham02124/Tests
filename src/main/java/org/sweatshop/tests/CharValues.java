package org.sweatshop.tests;

import static java.lang.String.format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharValues {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 255; i++) {
            System.out.println(format("%s = %s", i, (char) i));
        }
        
        System.out.println((int)'/');
        
        
        List<String> commands = new ArrayList<String>();
//        commands.add("/sbin/ping -o foo");
        commands.add("/sbin/ping -o localhost");
        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = pb.start();
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Success!");
        } else {
            System.out.println("failed with "+exitCode);
        }

    }

}
