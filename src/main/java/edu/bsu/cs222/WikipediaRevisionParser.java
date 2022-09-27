package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public static WikipediaRevision[] parse(InputStream testDataStream){
        JSONArray wiki = null;
        try {
            wiki = JsonPath.read(testDataStream, "$..*");
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(2);

        }
        JSONArray userName = JsonPath.read(wiki,"$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");
        if (userName.size()>0){
            WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
            for (int i = 0; i < userName.size(); i++){
                WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
                revisionList[i] = wikiRevision;
            } return revisionList;
        }
        else{
            System.err.println();
            System.exit(1);
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
            return "No redirects";
        }
    }
}
