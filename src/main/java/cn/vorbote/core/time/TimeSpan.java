package cn.vorbote.core.time;

import java.util.Objects;

/**
 * Represents a time interval. We use this class to show diffs from 2 {@code DateTime} instances.
 *
 * @author vorbote
 */
public final class TimeSpan {

    /**
     * The number of days between two times.
     */
    private int days;

    /**
     * The number of hours between two times.
     */
    private int hours;

    /**
     * The number of minutes between two times.
     */
    private int minutes;

    /**
     * The number of seconds between two times.
     */
    private int seconds;

    /**
     * No-args constructor, you can use this to build a {@code TimeSpan} with 0 days, 0 hours, 0 minutes and 0 seconds.
     */
    public TimeSpan() {
    }

    /**
     * Get the number of days between two times.
     *
     * @return The number of days between two times.
     */
    public int getDays() {
        return days;
    }

    /**
     * Set the number of days between two times.
     *
     * @param days The number of days between two times.
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Get the number of hours between two times.
     *
     * @return The number of hours between two times.
     */
    public int getHours() {
        return hours;
    }

    /**
     * Set the number of hours between two times.
     *
     * @param hours The number of hours between two times.
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Get the number of minutes between two times.
     *
     * @return The number of minutes between two times.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Set the minutes of days between two times.
     *
     * @param minutes The number of minutes between two times.
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * Get the number of seconds between two times.
     *
     * @return The number of seconds between two times.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Set the number of seconds between two times.
     *
     * @param seconds The number of seconds between two times.
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d:%02d:%02d",
                days, hours, minutes, seconds);
    }

    /**
     * Get the total seconds in this {@code TimeSpan}.
     *
     * @return The total seconds in this {@code TimeSpan}.
     */
    public long totalSeconds() {
        return days * 86400L + hours * 3600L + minutes * 60L + seconds;
    }

    /**
     * <b>This method is deprecated, please use {@link #totalSeconds()} instead. This method will be removed since next
     * release.</b><br>
     * Get the total seconds in this {@code TimeSpan}.
     *
     * @return The total seconds in this {@code TimeSpan}.
     */
    @Deprecated
    public long TotalSeconds() {
        return totalSeconds();
    }

    /**
     * Get the total hours in this {@code TimeSpan}.
     *
     * @return The total milliseconds in this {@code TimeSpan}.
     * @see #totalSeconds()
     */
    public double totalHours() {
        return totalSeconds() / 60. / 60.;
    }

    /**
     * <b>This method is deprecated, please use {@link #totalHours()} instead. This method will be removed since next
     * release.</b><br>
     * Get the total hours in this {@code TimeSpan}.
     *
     * @return The total milliseconds in this {@code TimeSpan}.
     * @see #totalHours()
     * @see #totalSeconds()
     */
    @Deprecated
    public double TotalHours() {
        return totalHours();
    }

    /**
     * Check that the given {@code Object} instance is equal to this instance.
     *
     * @param o The given {@code Object} instance,
     * @return Value {@code true} will be returned when the {@code Object} o is equal to this instance.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSpan timeSpan = (TimeSpan) o;
        return getDays() == timeSpan.getDays() && getHours() == timeSpan.getHours() && getMinutes() == timeSpan.getMinutes() && getSeconds() == timeSpan.getSeconds();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDays(), getHours(), getMinutes(), getSeconds());
    }

    /**
     * Generate a builder of {@code TimeSpan}.
     *
     * @return A builder of {@code TimeSpan}.
     */
    public static TimeSpan.Builder builder() {
        return new TimeSpan.Builder();
    }

    /**
     * Inner class {@code Builder} of {@code TimeSpan}.
     */
    public static class Builder {
        /**
         * The build result.
         */
        private final TimeSpan target;

        /**
         * Generate a new {@code Builder}, use protected to prevent other coders use it.
         */
        protected Builder() {
            target = new TimeSpan();
        }

        /**
         * Set the number of days between two times.
         *
         * @param days The number of days between two times.
         * @return {@code Builder} instance itself.
         */
        public Builder days(int days) {
            target.setDays(days);
            return this;
        }

        /**
         * Set the number of hours between two times.
         *
         * @param hours The number of hours between two times.
         * @return {@code Builder} instance itself.
         */
        public Builder hours(int hours) {
            target.setHours(hours);
            return this;
        }

        /**
         * Set the number of minutes between two times.
         *
         * @param minutes The number of minutes between two times.
         * @return {@code Builder} instance itself.
         */
        public Builder minutes(int minutes) {
            target.setMinutes(minutes);
            return this;
        }

        /**
         * Set the number of seconds between two times.
         *
         * @param seconds The number of seconds between two times.
         * @return {@code Builder} instance itself.
         */
        public Builder seconds(int seconds) {
            target.setSeconds(seconds);
            return this;
        }

        /**
         * Build a {@code TimeSpan} instance.
         *
         * @return A {@code TimeSpan} instance with specified data.
         */
        public TimeSpan build() {
            return target;
        }
    }
}
