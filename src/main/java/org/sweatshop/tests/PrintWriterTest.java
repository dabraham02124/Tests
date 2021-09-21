package org.sweatshop.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("PrintWriterOutputFile.txt");
        System.out.println(file.getAbsolutePath());
        try (PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < 10; i++) {
                pw.println("foo "+i);
                pw.flush();
            }
        }
    }

}
