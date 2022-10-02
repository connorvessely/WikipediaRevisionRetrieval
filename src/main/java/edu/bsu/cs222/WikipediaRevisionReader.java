package edu.bsu.cs222;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URL;

public class WikipediaRevisionReader {

    public static String getRevisionInfo (String searchValue){
        JSONArray wiki = null;
        try {
            wiki = WikipediaRevisionParser.parseJSON(getWikiStream(encodeURL(searchValue)));
            }
        catch (IOException e) {
            e.printStackTrace();
        }
        return WikipediaRevisionFormatter.formatter(wiki);
    }

    private static InputStream getWikiStream(URL encodedUrl) {
        URLConnection connection = null;
        try {
            connection = encodedUrl.openConnection();
            connection.setRequestProperty("User-Agent", "WikipediaRevisionReader/0.1 sivelasco@bsu.edu");
            return connection.getInputStream();
        }
        catch (IOException e) {
            System.err.println("Network Connection Error");
            System.exit(3);
            return null;
        }
    }

    private static URL encodeURL (String articleTitle){
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30&redirects", articleTitle);
        URL url = null;
        try {
            url = new URL(urlString.replaceAll(" ", "%20"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}