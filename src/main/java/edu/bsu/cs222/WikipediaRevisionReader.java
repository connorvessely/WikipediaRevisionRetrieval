package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

public class WikipediaRevisionReader {

    public static void main(String[] args){

        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //err handling if nothing is entered.
        if (line.isBlank()){
            System.err.println("Nothing was entered.");
            System.exit(1);
        }

        try {
            String timestamp = revisionReader.getLatestRevisionOf(line);
            System.out.println(timestamp);
        }
        catch (IOException ioException){
            System.err.println("Network Connection Error: " + ioException.getMessage());
        }

    }

    private String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=30&redirects", articleTitle);
        String encodedUrlString = urlString.replaceAll(" ","%20");
        try {
            URL url = new URL(encodedUrlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "WikipediaRevisionReader/0.1 sivelasco@bsu.edu");
            InputStream inputStream = connection.getInputStream();
            return WikipediaRevisionParser.parse(inputStream);
        }
        catch (MalformedURLException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
    }

}
