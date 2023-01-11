package org.example;
import java.lang.String;
public class Teams {
    int win, loss, pts, draw;
    String team;
    Teams (){
        win = 0;
        loss = 0;
        pts = 0;
        draw = 0;
        team = "";
    }
    Teams(String team, int win, int draw, int loss, int pts){
        this.win = win;
        this.loss = loss;
        this.draw = draw;
        this.pts = pts;
        this.team=team.substring(1,team.length()-3).replaceAll("\\d","");
    }
    int getWin(){
        return win;
    }
    int getLoss(){
        return loss;
    }
    int getPts(){
        return pts;
    }
    public String toString(){
        return team + ", Wins: " + win +  ", Draws: " + draw + ", Losses: "+loss + ", Pts: " + pts;
    }
}
