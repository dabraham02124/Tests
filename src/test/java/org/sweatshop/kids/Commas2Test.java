package org.sweatshop.kids;

import static org.testng.Assert.assertEquals;

import org.sweatshop.kids.Commas2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Commas2Test {

    @Test(dataProvider = "commasWithDecimalTestDP")
    public void commasWithDecimalTest(String in, String expected) {
        assertEquals(Commas2.commasWithDecimal(in), expected);
    }

    @Test(dataProvider = "commasBothWaysWithDecimalTestDP")
    public void commasBothWaysWithDecimalTest(String in, String expected) {
        assertEquals(Commas2.commasBothWaysWithDecimal(in), expected);
    }

    @Test(dataProvider = "reverseStringTestDP")
    public void reverseStringTest(String in, String expected) {
        assertEquals(Commas2.reverseString(in), expected);
    }

    @DataProvider
    public Object[][] reverseStringTestDP() {
        return new Object[][] {
            {null, ""},
            {"", ""},
            {"a", "a"},
            {"ab", "ba"},
            {"aba", "aba"},
        };
    }
    
    @DataProvider
    public Object[][] commasWithDecimalTestDP() {
        return new Object[][] {
            {null, ""},
            {"", ""},
            {".", "."},
            {"1", "1"},
            {"12", "12"},
            {"123", "123"},
            {"1234", "1,234"},
            {"123456", "123,456"},

            {"1.", "1."},
            {".1", ".1"},
            {"12.1", "12.1"},
            {"123.123", "123.123"},
            {"1234.1234", "1,234.1234"},
            {"123456.123456", "123,456.123456"},
            {".123456", ".123456"},
        };
    }

    @DataProvider
    public Object[][] commasBothWaysWithDecimalTestDP() {
        return new Object[][] {
            {null, ""},
            {"", ""},
            {".", "."},
            {"1", "1"},
            {"12", "12"},
            {"123", "123"},
            {"1234", "1,234"},
            {"123456", "123,456"},

            {"1.", "1."},
            {".1", ".1"},
            {"12.1", "12.1"},
            {"123.123", "123.123"},
            {"1234.1234", "1,234.123,4"},
            {"123456.123456", "123,456.123,456"},
            {".123456", ".123,456"},
        };
    }

}
