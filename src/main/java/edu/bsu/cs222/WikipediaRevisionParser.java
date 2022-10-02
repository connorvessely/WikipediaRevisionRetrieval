package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {

    public static JSONArray parseJSON (InputStream inputStream) throws IOException {
        return JsonPath.read(inputStream, "$..*");
    }

    public static WikipediaRevision[] parseRevisions(JSONArray wiki){
        JSONArray userName = JsonPath.read(wiki, "$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");
        WikipediaRevision[] revisionList = new WikipediaRevision[30];
        if (userName.isEmpty()) {
            System.err.println("No Wikipedia page for that title was found.");
            System.exit(2);
        }
        for (int i = 0; i < revisionList.length; i++) {
            WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
            revisionList[i] = wikiRevision;
        }
        return revisionList;
    }

    public static String parseRedirect(JSONArray wiki) {
        JSONArray articleTitle = JsonPath.read(wiki, "$..redirects..to");
        if (articleTitle.size()>0) {
            return "Redirected to " + articleTitle.get(0);
        }
        else {
            articleTitle = JsonPath.read(wiki, "$..title");
            return "No redirects: " + articleTitle.get(0);
        }
    }
}