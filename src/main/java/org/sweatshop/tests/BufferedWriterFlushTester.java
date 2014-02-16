package org.sweatshop.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterFlushTester {

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("testerFile.txt")))) {
            for (int i = 0; i < 100; i++) {
                bw.write(i+"\n");
                bw.flush();
            }
            
        }

    }

}
