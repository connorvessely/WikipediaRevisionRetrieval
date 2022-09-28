package edu.bsu.cs222;

public class WikipediaRevision {

    private String author;
    private String timestamp;

    public WikipediaRevision(String author, String timestamp){
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getAuthor(){
        return author;
    }

    public String getTimestamp(){
        return timestamp;
    }
}
