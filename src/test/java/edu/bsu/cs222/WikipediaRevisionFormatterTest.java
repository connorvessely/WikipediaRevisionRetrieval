package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionFormatterTest {

    @Test
    public void testFormatter() throws IOException {
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String result = WikipediaRevisionFormatter.formatter(JsonPath.read(testDataStream, "$.*"));
        String expected = "No redirects: Jamie Foxx\nRecent revisions: \n2022-08-17T11:15:19Z Rlink2\n2022-08-05T19:13:10Z Zmbro\n2022-07-19T20:57:41Z Smallish1Uno\n2022-07-19T20:57:15Z Smallish1Uno\n";
        Assertions.assertEquals(result, expected);
    }
}
