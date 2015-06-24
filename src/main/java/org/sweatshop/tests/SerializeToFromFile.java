package org.sweatshop.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeToFromFile {

    public static void main(String[] args) {
        Double d = new Double(0.483); 
        
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("target/fileName.txt")))) {
            oos.writeObject(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("target/fileName.txt")))) {
            Object o = ois.readObject();
            if (!o.equals(d) || !d.equals(o)) {
                throw new Exception ("serialization changed my object!");
            } else {
                System.out.println("objects are the same");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
