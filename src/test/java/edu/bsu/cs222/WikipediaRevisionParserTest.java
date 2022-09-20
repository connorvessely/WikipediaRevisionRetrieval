package edu.bsu.cs222;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParse(){
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LearningTestJamieFoxx.json");
        String timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2022-08-17T11:15:19Z", timestamp);


    }
}
