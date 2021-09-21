package org.sweatshop.kids;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.sweatshop.kids.WordCounter.WcResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordCounterTest {

    @Test(dataProvider = "countTestDP")
    public void countTest(Path path, WcResult expected) throws FileNotFoundException, IOException {
        assertEquals(WordCounter.count(path), expected);
    }
    
    @DataProvider
    public Object[][] countTestDP() {
        return new Object[][] {
            {Paths.get("src/test/resources/emptyFile"), new WcResult(0,0,0)},
            {Paths.get("src/test/resources/justAChar"), new WcResult(0,1,1)},
            {Paths.get("src/test/resources/justANewline"), new WcResult(1,0,1)},
            {Paths.get("src/test/resources/justAWord"), new WcResult(0,1,6)},
            {Paths.get("src/test/resources/twoWords"), new WcResult(0,2,11)},
        };
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void countTestThrows() throws FileNotFoundException, IOException {
        WordCounter.count(Paths.get("/does-not-exist"));
    }
 
}
