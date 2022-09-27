package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public static WikipediaRevision[] parse(InputStream testDataStream) throws IOException {
        JSONArray wiki = JsonPath.read(testDataStream, "$..*");
        JSONArray userName = JsonPath.read(wiki,"$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");
        if (userName.size()>0){
            WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
            for (int i = 0; i < 30; i++){
                WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
                revisionList[i] = wikiRevision;
            } return revisionList;
        }
        else {
            System.err.println("No wikipedia page for your input.");
            System.exit(2);
            return null;
        }
    }

    public String parseRedirect(InputStream testDataStream) throws IOException {
        JSONArray wiki =  JsonPath.read(testDataStream, "$..*");
        JSONArray articleTitle = JsonPath.read(wiki, "$..redirects..to");
        if (articleTitle.size()>0) {
            return "Redirected to " + articleTitle.get(0);
        }
        else {
            articleTitle = JsonPath.read(wiki, "$..title");
            return "No redirects\n" + articleTitle.get(0);
        }
    }
}
