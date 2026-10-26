package com.gathin.tvhome;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;

/** Bounded, fail-closed parser for the agenda embedded by the club's official site. */
final class MillosFixtureParser {
    static final class Fixture {
        final String home, away, competition;
        final Instant kickoff;
        Fixture(String home,String away,String competition,Instant kickoff){this.home=home;this.away=away;this.competition=competition;this.kickoff=kickoff;}
    }
    static Fixture next(String html,Instant now){
        if(html==null || html.length()>1_000_000 || !html.matches("(?s).*originalGMT\\s*=\\s*-0?3\\s*;.*"))return null;
        Pattern block=Pattern.compile("<div class=\"dfMc-Module[^\"]*mc-notStarted[^\"]*\"[^>]*data-title=\"([^\"]+)\"[^>]*data-dia=\"(\\d{8})\"[^>]*data-hora=\"(\\d{2}:\\d{2})\"[^>]*>(.*?)(?=<div class=\"dfMc-Module|$)",Pattern.DOTALL);
        Matcher m=block.matcher(html);Fixture best=null;
        while(m.find()){
            Matcher names=Pattern.compile("<img[^>]*class=\"mc-teamLogo\"[^>]*alt=\"([^\"]+)\"").matcher(m.group(4));
            if(!names.find())continue;String home=names.group(1);
            if(!names.find())continue;String away=names.group(1);
            if(!home.equals("Millonarios")&&!away.equals("Millonarios"))continue;
            try{
                Instant time=LocalDateTime.parse(m.group(2)+" "+m.group(3),DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")).toInstant(ZoneOffset.ofHours(-3));
                if(!time.isAfter(now))continue;
                Fixture f=new Fixture(home,away,m.group(1).equals("colombia")?"Liga BetPlay":"Copa Colombia",time);
                if(best==null||time.isBefore(best.kickoff))best=f;
            }catch(java.time.DateTimeException ignored){ /* malformed provider row: never guess */ }
        }
        return best;
    }
}
