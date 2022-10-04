package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            System.err.println("No value entered.");
            System.exit(1);
        }

        URL wikiUrl = WikipediaRevisionReader.encodeURL(input);

        InputStream wikiStream = null;
        try {
            wikiStream = WikipediaRevisionReader.getWikiStream(wikiUrl);
        }
        catch (IOException e) {
            System.err.println("Network connection error.");
            System.exit(3);
        }

        JSONArray wiki = null;
        try {
            wiki = WikipediaRevisionParser.parseJSON(wikiStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if (WikipediaRevisionParser.parseRevisions(wiki).length==0) {
            System.err.println("No Wikipedia page for that title was found.");
            System.exit(2);
        }

        System.out.println(WikipediaRevisionFormatter.formatter(wiki));
    }
}
