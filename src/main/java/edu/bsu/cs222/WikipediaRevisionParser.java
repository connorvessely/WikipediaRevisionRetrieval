package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public static WikipediaRevision[] parse(InputStream testDataStream) throws IOException {
        JSONArray wiki = (JSONArray) JsonPath.read(testDataStream, "$..*");
        JSONArray userName = JsonPath.read(wiki,"$..user");
        JSONArray timestamp = JsonPath.read(wiki, "$..timestamp");

        if (userName.size()>0){
            WikipediaRevision[] revisionList = new WikipediaRevision[userName.size()];
            for (int i = 0; i < userName.size(); i++){
                WikipediaRevision wikiRevision = new WikipediaRevision(userName.get(i).toString(), timestamp.get(i).toString());
                revisionList[i] = wikiRevision;
            } return revisionList;

        } return null;
    }
}
