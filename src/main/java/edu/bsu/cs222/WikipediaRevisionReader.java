package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;

public class WikipediaRevisionReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isBlank()) {
            System.err.println("No value entered.");
            System.exit(2);
        }
        else {
            WikipediaRevision[] revisionList = getLatestRevisionOf(line);
            String formattedRevisionList = WikipediaRevisionFormatter.formatter(revisionList);
            System.out.println(getRedirects(line));
            System.out.println(formattedRevisionList);
        }
    }

    private static WikipediaRevision[] getLatestRevisionOf(String articleTitle) {
        return WikipediaRevisionParser.parse(encodeUrl(articleTitle));
    }

    private static String getRedirects(String articleTitle) {
        WikipediaRevisionParser wikipediaRevisionParser = new WikipediaRevisionParser();
        return wikipediaRevisionParser.parseRedirect(encodeUrl(articleTitle));
    }

    private static InputStream encodeUrl(String articleTitle) {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30&redirects", articleTitle);
        try {
            URL url = new URL(urlString.replaceAll(" ", "%20"));
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaRevisionReader/0.1 sivelasco@bsu.edu");
            return connection.getInputStream();
        }
        catch (IOException e) {
            System.err.println("Network Connection Error");
            System.exit(3);
            return null;
        }
    }
}