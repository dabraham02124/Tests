package org.sweatshop.tests;

import org.testng.annotations.Test;
import org.testng.asserts.*;

public class SoftAssertionTest {
    
    @Test
    public void SoftAssertionTestTest() {
        SoftAssert sa = new SoftAssert();
        
        sa.assertEquals("arugula", "kale");
        sa.assertEquals("fred", "barney");
//this line would fail with both errors
//        sa.assertAll();
        
        
//      org.hamcrest.MatcherAssert.assertThat("arugula", org.hamcrest.Matchers.containsString("Not found"));
    }

}
