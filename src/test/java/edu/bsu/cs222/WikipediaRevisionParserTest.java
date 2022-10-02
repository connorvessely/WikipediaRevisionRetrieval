package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class WikipediaRevisionParserTest {
    @Test
    public void testParseAuthor() {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(testDataStream);
        Assertions.assertEquals(revisionList[0].getAuthor(), "Rlink2");
    }

    @Test
    public void testParseTimestamp(){
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(testDataStream);
        Assertions.assertEquals(revisionList[0].getTimestamp(), "2022-08-17T11:15:19Z");
    }

    @Test
    public void testRedirectParse(){
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String result = WikipediaRevisionParser.parseRedirect(testDataStream);
        Assertions.assertEquals("No redirects: Jamie Foxx", result);
    }
}
