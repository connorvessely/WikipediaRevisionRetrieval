package edu.bsu.cs222;


public class WikipediaRevisionFormatter {

    public static String formatter(WikipediaRevision[] revisionList){
        StringBuilder formattedRevisions= new StringBuilder();
        for (int i = 0; i < 30; i++) {
            formattedRevisions = new StringBuilder(formattedRevisions + revisionList[i].getTimestamp() + " " +
                    revisionList[i].getAuthor() + "\n");
        }
        return formattedRevisions.toString();
    }

}
