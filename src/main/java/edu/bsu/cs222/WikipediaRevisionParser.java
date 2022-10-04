package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

import static com.jayway.jsonpath.JsonPath.read;

public class WikipediaRevisionParser {

    public static JSONArray parseJSON (InputStream inputStream) throws IOException {
        return JsonPath.read(inputStream, "$.*");
    }

    public static WikipediaRevision[] parseRevisions(JSONArray wiki){
        JSONArray userName = read(wiki, "$..user");
        JSONArray timestamp = read(wiki, "$..timestamp");
        WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
        for (int i = 0; i < userName.size(); i++) {
            WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
            revisionList[i] = wikiRevision;
        }
        return revisionList;
    }

    public static String parseRedirect(JSONArray wiki) {
        JSONArray articleTitle = read(wiki, "$..redirects..to");
        if (articleTitle.size()>0) {
            return "Redirected to " + articleTitle.get(0);
        }
        else {
            articleTitle = read(wiki, "$..title");
            return "No redirects: " + articleTitle.get(0);
        }
    }
}