package org.sweatshop.kids;

import static org.testng.Assert.assertEquals;

import org.sweatshop.kids.Commas;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommasTest {


    @Test(dataProvider = "commasTestDP")
    public void commasTest(String in, String expected) {
        assertEquals(Commas.commas(in), expected);
    }
    
    @DataProvider
    public Object[][] commasTestDP() {
        return new Object[][] {
            {null, ""},
            {"", ""},
            {"1", "1"},
            {"12", "12"},
            {"123", "123"},
            {"1234", "1,234"},
            {"12345", "12,345"},
            {"123456", "123,456"},
            {"1234567", "1,234,567"},
            {"12345678", "12,345,678"},
            {"123456789", "123,456,789"},
            {"1234567890", "1,234,567,890"},
            {"12345678901234567890", "12,345,678,901,234,567,890"},
        };
    }
}
