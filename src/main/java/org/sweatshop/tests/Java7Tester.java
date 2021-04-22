package org.sweatshop.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Java7Tester implements Foo, Bar {

    public Java7Tester() {
        autoClose();
        stringSwitch();
        inferGenerics();
        binaryLiteral();
        underScoresInLiterals();
        catchMultiples();
        try {
            rethrowPreciseException("FirstException");
        } catch (FirstException | SecondException e) {
            e.printStackTrace();
        }
    }

    private void catchMultiples() {
        try {
            thrower();
        } catch (SQLException | IOException e) {
            //note the 2 exceptions on the previous line
            System.out.println("not doing anything");
        }
    }

    /**
     * just here to have something to catch
     * @throws SQLException
     * @throws IOException
     */
    private void thrower() throws SQLException, IOException {
    }

    private boolean compare(int i1, int i2) {
        return i1 == i2;
    }
    private void underScoresInLiterals() {
        if (compare(1000000, 1_000_000)) {
            System.out.println("equals");
        }
    }

    private void binaryLiteral() {
        byte b = 0b1;
        System.out.println(b);
    }

    private void autoClose() {
        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
        } catch (Exception e) {
        }//don't need finally to close it
    }

    private void stringSwitch() {
        String s = "";
        switch (s) {
            case "abc" : System.out.println("abc");
        }
    }

    private static int inferGenerics() {
        Map <String, String> map = new HashMap<>();
        System.out.println(map);
        return 0;
    }

    static class FirstException extends Exception {
        private static final long serialVersionUID = -7273673538362826978L; }
    static class SecondException extends Exception {
        private static final long serialVersionUID = 4392574482560901510L; }

    /**
     * Note that the throws only throws First & Second, even though the catch catches Exception.
     * @param exceptionName
     * @throws FirstException
     * @throws SecondException
     */
    public void rethrowPreciseException(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void bar() {
        // TODO Auto-generated method stub
    }

}
