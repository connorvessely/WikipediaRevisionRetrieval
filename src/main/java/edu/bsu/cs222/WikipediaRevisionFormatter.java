package edu.bsu.cs222;

public class WikipediaRevisionFormatter {
    public static String formatter(WikipediaRevision[] revisionList){
        StringBuilder formattedRevisions= new StringBuilder("Last 30 revisions: \n");
        for (int i=0; i<30; i++) {
            formattedRevisions.append(revisionList[i].getTimestamp()).append(" ").append(revisionList[i].getAuthor()).append("\n");
        }
        return formattedRevisions.toString();
    }
}
