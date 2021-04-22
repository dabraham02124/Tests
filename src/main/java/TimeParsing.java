import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


public class TimeParsing {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;

        TemporalAccessor date1 = dtf.parse("2016-02-03T13:38:56.123Z");
        TemporalAccessor date2 = dtf.parse("2016-02-03T13:38:56.123Z");
        TemporalAccessor date3 = dtf.parse("2016-02-03 13:38:56.123Z");
        TemporalAccessor date4 = dtf.parse("2016-02-03 13:38:56,123Z");

        if (!date1.equals(date2) || !date2.equals(date3) || !date3.equals(date4)) {
            throw new RuntimeException("not equal");
        }
    }

}
