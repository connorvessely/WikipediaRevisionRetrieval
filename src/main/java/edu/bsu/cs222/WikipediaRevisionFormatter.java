package edu.bsu.cs222;


public class WikipediaRevisionFormatter {

    public static String formatter(WikipediaRevision[] revisionList){
        StringBuilder formattedRevisions= new StringBuilder();
        for (WikipediaRevision revision: revisionList) {
            formattedRevisions.append(revision.toString());
        }
        return formattedRevisions.toString();
    }

}
