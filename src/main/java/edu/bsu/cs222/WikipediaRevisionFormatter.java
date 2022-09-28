package edu.bsu.cs222;

public class WikipediaRevisionFormatter {

    public static String formatter(WikipediaRevision[] revisionList){
        StringBuilder formattedRevisions= new StringBuilder("Recent revisions: \n");
        if (revisionList.length>30){
            for (int i=0; i<30; i++) {
                formattedRevisions.append(revisionList[i].getTimestamp()).append(" ").append(revisionList[i].getAuthor()).append("\n");
            }
        }
        else {
            for (int i = 0; i < 4; i++) {
                formattedRevisions.append(revisionList[i].getTimestamp()).append(" ").append(revisionList[i].getAuthor()).append("\n");
            }
        }
        return formattedRevisions.toString();
    }
}
