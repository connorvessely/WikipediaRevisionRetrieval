package edu.bsu.cs222;

import net.minidev.json.JSONArray;

public class WikipediaRevisionFormatter {

    public static String formatter(JSONArray wiki) {
        WikipediaRevision[] revisionList = WikipediaRevisionParser.parseRevisions(wiki);
        String redirects = WikipediaRevisionParser.parseRedirect(wiki);
        StringBuilder formattedRevisions= new StringBuilder(String.format("%s\nRecent revisions: \n", redirects));
        for (int i=0; i<revisionList.length; i++) {
            formattedRevisions.append(revisionList[i].getTimestamp()).append(" ").append(revisionList[i].getAuthor()).append("\n");
        }
        return formattedRevisions.toString();
    }
}
