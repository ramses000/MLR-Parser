package org.example;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        HtmlPage searchPage = client.getPage("https://www.espn.com/rugby/table/_/league/289262");
        parseResults(searchPage);
    }
    private static void parseResults(HtmlPage resultsPage) {
        HtmlTable table = (HtmlTable) resultsPage.getByXPath(("//table")).get(0);
        List<Teams> teams = table.getBodies().get(0).getRows().stream()
                .map(r -> {
                    String rating = r.getCell(14).getTextContent();
                    String wins = r.getCell(1).getTextContent();
                    String draws = r.getCell(2).getTextContent();
                    String loses = r.getCell(3).getTextContent();
                    return new Teams(
                            r.getCell(0).getTextContent(),
                            wins.length() == 0? null:Integer.parseInt(wins),
                            draws.length() == 0? null:Integer.parseInt(draws),
                            loses.length() == 0? null:Integer.parseInt(loses),
                            rating.length() == 0? null: Integer.parseInt(rating)
                    );
                }).collect(Collectors.toList());
        for(Teams team: teams){
            System.out.println(team);
        }
    }
}