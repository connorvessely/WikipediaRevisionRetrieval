package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public static WikipediaRevision[] parse(InputStream testDataStream) {
        WikipediaRevision[] result;
        JSONArray wiki = null;
        try {
            wiki = JsonPath.read(testDataStream, "$..*");
        } catch (IOException e) {
            System.err.println("JSONArray wiki empty");
            e.printStackTrace();
        }
        JSONArray userName = JsonPath.read(wiki, "$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");
        if (userName.size() > 30) {
            WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
            for (int i = 0; i < 30; i++) {
                WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
                revisionList[i] = wikiRevision;
            }
            result = revisionList;
        }
        else if (userName.size() < 30 && userName.size() > 0){
            WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
            for (int i = 0; i < userName.size(); i++) {
                WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
                revisionList[i] = wikiRevision;
            }
            result = revisionList;
        }
        else {
            System.err.println("No wikipedia page for your input.");
            System.exit(2);
            result = null;
        }
        return result;
    }

    public static String parseRedirect(InputStream testDataStream) {
        JSONArray wiki = null;
        try {
            wiki = JsonPath.read(testDataStream, "$..*");
        }
        catch (IOException e) {
            System.err.println("Empty JSON");
            e.printStackTrace();
        }
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
