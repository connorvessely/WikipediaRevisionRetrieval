package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {

    @Test
    public void testParseAuthor0() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[0].getAuthor(), "Rlink2");
    }

    @Test
    public void testParseTimestamp0() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[0].getTimestamp(), "2022-08-17T11:15:19Z");
    }

    @Test
    public void testParseAuthor1() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[1].getAuthor(), "Zmbro");
    }

    @Test
    public void testParseTimestamp1() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[1].getTimestamp(), "2022-08-05T19:13:10Z");
    }

    @Test
    public void testParseAuthor2() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[2].getAuthor(), "Smallish1Uno");
    }

    @Test
    public void testParseTimestamp2() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[2].getTimestamp(), "2022-07-19T20:57:41Z");
    }

    @Test
    public void testParseAuthor3() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[3].getAuthor(), "Smallish1Uno");
    }

    @Test
    public void testParseTimestamp3() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals(revisionList[3].getTimestamp(), "2022-07-19T20:57:15Z");
    }

    @Test
    public void testRedirectParse() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String result = WikipediaRevisionParser.parseRedirect(WikipediaRevisionParser.parseJSON(testDataStream));
        Assertions.assertEquals("No redirects: Jamie Foxx", result);
    }
}
