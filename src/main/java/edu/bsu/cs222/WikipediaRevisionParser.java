package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public static String parse(InputStream testDataStream) throws IOException {
        JSONArray wiki = (JSONArray) JsonPath.read(testDataStream, "$..*");
        JSONArray titleResult = JsonPath.read(wiki,"$..redirects..to");
        JSONArray userName = JsonPath.read(wiki,"$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");
        return timestamp.get(0).toString();
    }
}
