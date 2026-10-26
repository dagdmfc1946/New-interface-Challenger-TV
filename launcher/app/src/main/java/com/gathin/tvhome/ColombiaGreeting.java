package com.gathin.tvhome;

import java.time.Instant;
import java.time.ZoneId;

/** The owner's local day parts, independent of an es-ES language setting. */
final class ColombiaGreeting {
    private ColombiaGreeting() {}

    static int resourceAt(Instant now) {
        int hour = now.atZone(ZoneId.of("America/Bogota")).getHour();
        if (hour < 5) return R.string.good_night;
        if (hour < 12) return R.string.good_morning;
        if (hour < 18) return R.string.good_afternoon;
        return R.string.good_night;
    }
}
