package seedu.address.model.reminder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a date and time.
 */
public class DateTime implements Comparable<DateTime> {
    public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd 'at' HH:mm";
    private final String dateTime;

    public DateTime(String dateTime) {
        assert(isValidDateTimeString(dateTime));
        this.dateTime = dateTime;
    }

    public String getDateTimeString() {
        return this.dateTime;
    }

    @Override
    public int compareTo(DateTime other) {
        return this.getLocalDateTime().compareTo(other.getLocalDateTime());
    }

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER));
    }

    /**
     * Returns true if {@code dateTimeString} is a valid date time.
     */
    public static boolean isValidDateTimeString(String dateTimeString) {
        try {
            LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER));
            return true;
        } catch (DateTimeParseException pe) {
            return false;
        }
    }

    @Override
    public String toString() {
        return dateTime;
    }
}
