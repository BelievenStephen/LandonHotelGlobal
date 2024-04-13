package edu.wgu.d387_sample_code;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;

public class TimeConversion {

    public static List<String> getConvertedTimes(){
        LocalDateTime localDateTime = LocalDateTime.of(2024, 4, 20, 10, 0);
        ZoneId est = ZoneId.of("America/New_York");
        ZoneId mt = ZoneId.of("America/Denver");
        ZoneId utc = ZoneId.of("UTC");

        ZonedDateTime estDateTime = localDateTime.atZone(est);
        ZonedDateTime mtDateTime = estDateTime.withZoneSameInstant(mt);
        ZonedDateTime utcDateTime = estDateTime.withZoneSameInstant(utc);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm z");
        String estString = estDateTime.format(formatter);
        String mtString = mtDateTime.format(formatter);
        String utcString = utcDateTime.format(formatter);

        return List.of(estString, mtString, utcString);
    }

}