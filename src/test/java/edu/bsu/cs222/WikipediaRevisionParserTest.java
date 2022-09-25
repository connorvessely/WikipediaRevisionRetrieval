package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LearningTestJamieFoxx.json");
        WikipediaRevision[] timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2022-08-17T11:15:19Z", timestamp);
    }

    @Test
    public void testTitleParse() throws IOException{
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("LearningTestJamieFoxx.json");
        WikipediaRevision[] title = parser.parse(testDataStream);
        Assertions.assertEquals("Jamie Foxx", title);
    }
}
