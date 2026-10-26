package com.gathin.tvhome;

import org.junit.Test;
import java.time.Instant;
import static org.junit.Assert.assertEquals;

public class ColombiaGreetingTest {
    @Test public void eveningInColombiaIsNightEvenWithSpainLanguage() {
        assertEquals(R.string.good_night, ColombiaGreeting.resourceAt(Instant.parse("2026-10-26T01:30:00Z")));
    }
    @Test public void nightStartsAtSixPmColombia() {
        assertEquals(R.string.good_afternoon, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T22:59:59Z")));
        assertEquals(R.string.good_night, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T23:00:00Z")));
    }
    @Test public void morningStartsAtFiveAmColombia() {
        assertEquals(R.string.good_night, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T09:59:59Z")));
        assertEquals(R.string.good_morning, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T10:00:00Z")));
    }
    @Test public void afternoonStartsAtNoonColombia() {
        assertEquals(R.string.good_morning, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T16:59:59Z")));
        assertEquals(R.string.good_afternoon, ColombiaGreeting.resourceAt(Instant.parse("2026-10-25T17:00:00Z")));
    }
}
