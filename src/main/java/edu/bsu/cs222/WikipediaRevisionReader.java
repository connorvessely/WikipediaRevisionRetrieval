package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

public class WikipediaRevisionReader {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            WikipediaRevision[] revisionList = getLatestRevisionOf(line);
            String formattedRevisionList = WikipediaRevisionFormatter.formatter(revisionList);
            System.out.println(getRedirects(line));
            System.out.println("Last 30 Revisions for " + '"' + line + '"' + ":");
            System.out.println(formattedRevisionList);
        }
        catch (IOException ioException){
            System.err.println("Network Connection Error: " + ioException.getMessage());
            System.exit(3);
        }
    }

    private static WikipediaRevision[] getLatestRevisionOf(String articleTitle) throws IOException {
        WikipediaRevisionParser wikipediaRevisionParser = new WikipediaRevisionParser();
        return wikipediaRevisionParser.parse(encodeUrl(articleTitle));
    }

    private static String getRedirects(String articleTitle) throws IOException {
        WikipediaRevisionParser wikipediaRevisionParser= new WikipediaRevisionParser();
        return wikipediaRevisionParser.parseRedirect(encodeUrl(articleTitle));
    }

    private static InputStream encodeUrl(String articleTitle) throws IOException{
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30&redirects", articleTitle);
        URL url = new URL(urlString.replaceAll(" ","%20"));
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "WikipediaRevisionReader/0.1 sivelasco@bsu.edu");
        return connection.getInputStream();
    }
}
