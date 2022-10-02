package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            System.err.println("No value entered.");
            System.exit(2);
        }

        URL wikiUrl = WikipediaRevisionReader.encodeURL(input);
        InputStream wikiStream = WikipediaRevisionReader.getWikiStream(wikiUrl);

        /*
        InputStream wikiStream = null;
        try {
            wikiStream = WikipediaRevisionReader.getWikiStream(wikiUrl).getInputStream();
        }
        catch (IOException e) {
            System.err.println("Network Connection Error");
            System.exit(3);
        }

         */

        JSONArray wiki = WikipediaRevisionParser.parseJSON(wikiStream);
        //System.err.println("No Wikipedia page for that title was found.");
        //System.exit(2);


        System.out.println(WikipediaRevisionFormatter.formatter(wiki));
    }
}
