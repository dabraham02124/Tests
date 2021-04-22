package org.sweatshop.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File f = new File(".");
        System.out.println(f.getAbsolutePath());
        Properties p = new Properties();
        p.load(new FileReader("src/test/resources/properties-test.properties"));
        System.out.println(p.getProperty("foo"));
        System.out.println("got to the end");
    }
    
}
