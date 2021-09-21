package org.sweatshop.kids;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HistogrammerTest {
    
    @Test
    public void instantiationTest() {
        new Histogrammer();
    }

    @Test(dataProvider="countDigitsTestDP")
    public void countDigitsTest(String in, int[] expected) {
        assertEquals(Histogrammer.countDigits(in), expected);
    }

    @DataProvider
    public Object[][] countDigitsTestDP() {
        return new Object[][] {
            {null, new int[]{0,0,0,0,0,0,0,0,0,0}},
            {"", new int[]{0,0,0,0,0,0,0,0,0,0}},

            {"0", new int[]{1,0,0,0,0,0,0,0,0,0}},
            {"00", new int[]{2,0,0,0,0,0,0,0,0,0}},
            {"01", new int[]{1,1,0,0,0,0,0,0,0,0}},
            {"314159", new int[]{0,2,0,1,1,1,0,0,0,1}},
        };
    }
    
    @Test (dataProvider = "lateralHistogramTestDP")
    public void lateralHistogramTest(String in, String expected) {
        assertEquals(Histogrammer.lateralHistogram(in), expected);
    }

    @DataProvider
    Object[][] lateralHistogramTestDP() {
        String emptyHistogram = "0| \n1| \n2| \n3| \n4| \n5| \n6| \n7| \n8| \n9| \n";
        return new Object[][] {
            {null, emptyHistogram},
            {"", emptyHistogram},

            {"0", "0| *\n1| \n2| \n3| \n4| \n5| \n6| \n7| \n8| \n9| \n"},
            {"101", "0| *\n1| **\n2| \n3| \n4| \n5| \n6| \n7| \n8| \n9| \n"},
            {"31415926", "0| \n1| **\n2| *\n3| *\n4| *\n5| *\n6| *\n7| \n8| \n9| *\n"},
        };
    }

    @Test (dataProvider = "verticalHistogramTestDP")
    public void verticalHistogramTest(String in, String expected) {
        assertEquals(Histogrammer.verticalHistogram(in), expected);
    }

    @DataProvider
    Object[][] verticalHistogramTestDP() {
        String emptyHistogram = "  ---------------------\n    0 1 2 3 4 5 6 7 8 9";
        return new Object[][] {
            {null, emptyHistogram},
            {"", emptyHistogram},

            {"0", "1 | *                   \n" + emptyHistogram},
            {"101", "2 |   *                 \n1 | * *                 \n" + emptyHistogram},
            {"31415926", "2 |   *                 \n1 |   * * * * * *     * \n" + emptyHistogram},
            {"31415903333", "5 |       *             \n4 |       *             \n" + 
                    "3 |       *             \n2 |   *   *             \n" + 
                    "1 | * *   * * *       * \n" + emptyHistogram},
        };
    }

}
