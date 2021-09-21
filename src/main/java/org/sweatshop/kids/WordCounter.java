package org.sweatshop.kids;

import java.nio.file.Path;

import org.sweatshop.kids.WordCounter.WcResult.WcResultBuilder;

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.Builder;
import lombok.Value;

public class WordCounter {

    @Value
    @Builder
    public static class WcResult {
        int lines;
        int words;
        int characters;
    }


    private static Set<Character> whitespace = HashSet.of(' ', '\n', '\t');

    public static WcResult count(Path path) throws FileNotFoundException, IOException {
        
        List foo = List.of(1,2,3);
        
        
        try (FileReader fr = new FileReader(path.toAbsolutePath().toString());
                BufferedReader br = new BufferedReader(fr))
        {
            WcResultBuilder result = WcResult.builder();
            boolean inWord = false;

            while (true) {
                int tmp = br.read();
                if (-1 == tmp) {
                    break;
                }
                result.characters++;
                char c = (char) tmp;
                if (whitespace.contains(c)) {
                    inWord = false;
                    if (c == '\n') {
                        result.lines++;
                    }
                } else {
                    if (!inWord) {
                        inWord = true;
                        result.words++;
                    }
                }

            }
            return result.build();
        }
    }
}
