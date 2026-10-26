package com.gathin.tvhome;
import org.junit.Test;
import java.time.Instant;
import static org.junit.Assert.*;
public class MillosFixtureParserTest {
    private String row(String date,String time,String home,String away){return "<div class=\"dfMc-Module mc-notStarted\" data-title=\"colombia\" data-dia=\""+date+"\" data-hora=\""+time+"\"><img class=\"mc-teamLogo\" alt=\""+home+"\"><img class=\"mc-teamLogo\" alt=\""+away+"\">";}
    @Test public void convertsDeclaredProviderZoneAndSelectsNext(){
        String html="var originalGMT = -03;"+row("20261020","22:30","Millonarios","Once Caldas")+row("20261103","22:10","Millonarios","América de Cali");
        MillosFixtureParser.Fixture f=MillosFixtureParser.next(html,Instant.parse("2026-10-25T23:00:00Z"));
        assertNotNull(f);assertEquals("América de Cali",f.away);assertEquals(Instant.parse("2026-11-04T01:10:00Z"),f.kickoff);
    }
    @Test public void refusesUnspecifiedZoneAndWrongTeams(){assertNull(MillosFixtureParser.next(row("20261103","22:10","Millonarios","América"),Instant.EPOCH));assertNull(MillosFixtureParser.next("var originalGMT=-03;"+row("20261103","22:10","Otros","América"),Instant.EPOCH));}
    @Test public void doesNotShowFinishedOrMalformedDates(){assertNull(MillosFixtureParser.next("var originalGMT=-03;"+row("20269903","22:10","Millonarios","América"),Instant.EPOCH));}
}
