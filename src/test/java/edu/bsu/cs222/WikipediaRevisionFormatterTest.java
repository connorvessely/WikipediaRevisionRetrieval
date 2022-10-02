package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class WikipediaRevisionFormatterTest {

    @Test
    public void testFormatter(){
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        JSONArray revisions = WikipediaRevisionParser.parseRevisions(JsonPath.read(testDataStream));
        String result= WikipediaRevisionFormatter.formatter(revisions);
        String expected = "Recent revisions: \n2022-08-17T11:15:19Z Rlink2\n2022-08-05T19:13:10Z Zmbro\n2022-07-19T20:57:41Z Smallish1Uno\n2022-07-19T20:57:15Z Smallish1Uno\n";
        Assertions.assertEquals(result, expected);
    }

}
