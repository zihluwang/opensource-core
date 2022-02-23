package cn.vorbote.core.utils;

/**
 * Miscellaneous {@link String} utility methods.
 *
 * @author vorbote
 */
public final class StringUtil {

    /**
     * Private Constructor will prevent coders build a instance of this util class.
     */
    private StringUtil() {
    }

    /**
     * Check whether the given {@code CharSequence} contains any non-whitespace text.
     *
     * @param str The candidate {@code CharSequence}.
     * @return Value {@code true} while the candidate string contains any non-whitespace text otherwise return value
     * {@code false}.
     */
    private static boolean containsText(CharSequence str) {
        var strLen = str.length();
        for (var i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;

    }

    /**
     * Check whether the given {@code String} is empty.
     *
     * @param str The candidate string.
     * @return Value {@code true} while the candidate string is empty otherwise return value {@code false}.
     */
    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    /**
     * Check that the given {@code CharSequence} is neither {@code null} nor of length 0.
     *
     * @param str The {@code CharSequence} to check (maybe {@code null}).
     * @return Value {@code true} if the {@code CharSequence} is not {@code null} and has length.
     */
    public static boolean hasLength(CharSequence str) {
        return !(str == null || str.length() <= 0);
    }

    /**
     * Check that the given {@code String} is neither {@code null} nor of length 0.
     *
     * @param str The {@code String} to check (maybe {@code null}).
     * @return Value {@code true} if the {@code String} is not {@code null} and has length.
     */
    public static boolean hasLength(String str) {
        return (str != null && !str.isEmpty());
    }

    /**
     * Check whether the given {@code CharSequence} contains actual <em>text</em>.
     *
     * @param str The {@code CharSequence} to check (maybe {@code null})
     * @return Value {@code true} if the {@code CharSequence} is not {@code null}, its length is greater than 0, and it
     * does not contain whitespace only.
     */
    public static boolean hasText(CharSequence str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    /**
     * Check whether the given {@code CharSequence} contains actual <em>text</em>.
     *
     * @param str The {@code CharSequence} to check (maybe {@code null})
     * @return Value {@code true} if the {@code CharSequence} is not {@code null}, its length is greater than 0, and it
     * does not contain whitespace only.
     */
    public static boolean doesNotHaveText(CharSequence str) {
        return !hasText(str);
    }

    /**
     * Check whether the given {@code String} contains actual <em>text</em>.
     *
     * @param str The {@code String} to check (maybe {@code null})
     * @return Value {@code true} if the {@code String} is not {@code null}, its length is greater than 0, and it does
     * not contain whitespace only.
     */
    public static boolean hasText(String str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    /**
     * Check whether the given {@code String} contains actual <em>text</em>.
     *
     * @param str The {@code String} to check (maybe {@code null})
     * @return Value {@code true} if the {@code String} is {@code null}, its length is less than 0, or it contains
     * whitespace only.
     */
    public static boolean doesNotHaveText(String str) {
        return !hasText(str);
    }

    /**
     * Check whether the given {@code CharSequence} contains any whitespace characters.
     *
     * @param str The {@code CharSequence} to check (maybe {@code null}).
     * @return Value {@code true} if the {@code CharSequence} is not empty and contains at lease 1 whitespace
     * characters.
     * @see Character#isWhitespace(char)
     */
    public static boolean containsWhitespace(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        var strLength = str.length();
        for (var i = 0; i < strLength; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check whether the given {@code String} contains any whitespace characters.
     *
     * @param str The {@code String} to check (maybe {@code null}).
     * @return Value {@code true} if the {@code String} is not empty and contains at lease 1 whitespace characters.
     * @see #containsWhitespace(CharSequence)
     */
    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    /**
     * Trim leading and trailing whitespace from the given {@code String}.
     *
     * @param str The {@code String} to check.
     * @return The trimmed {@code String}.
     * @see Character#isWhitespace(char)
     */
    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        var beginIndex = 0;
        var endIndex = str.length() - 1;

        while (beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))) {
            beginIndex++;
        }

        while (endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))) {
            endIndex--;
        }

        return str.substring(beginIndex, endIndex + 1);
    }

    /**
     * Trim <i>all</i> whitespace from the given {@code String}: leading, trailing, and in between characters.
     *
     * @param str The {@code String} to check.
     * @return The trimmed {@code String}.
     * @see Character#isWhitespace(char)
     */
    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }

        var len = str.length();
        var builder = new StringBuilder(str.length());

        for (var i = 0; i < len; ++i) {
            var c = str.charAt(i);
            if (!Character.isWhitespace(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    /**
     * To count how many times does the substring in the base string.
     *
     * @param base      The original string.
     * @param substring The substring.
     * @return The number of the count.
     * @see #count(String, String)
     */
    public static int count(String base, String substring) {
        if (substring == null || "".equals(substring)) return 0;
        int count = 0;
        int fromIndex = 0;
        while (true) {
            int index = base.indexOf(substring, fromIndex);
            if (index == -1) break;
            fromIndex = index + 1;
            count++;
        }
        return count;
    }

    /**
     * <b>This method will be removed from version 3.5.0</b><br>
     * Count how many times does the substring in the base string. The same implementation with
     * {@link #count(String, String)}.
     *
     * @param base      The original string.
     * @param substring The substring.
     * @return The number of the count.
     */
    @Deprecated
    public static int Count(String base, String substring) {
        return count(base, substring);
    }

    /**
     * Check the string is empty. The same implementation with {@link #IsEmpty(String)} but with a java style
     * identifier.
     *
     * @param val The string you want to check
     * @return True while the string is empty, otherwise return false
     */
    public static boolean isEmpty(String val) {
        return val.isEmpty();
    }

    /**
     * <b>This method will be removed from version 3.5.0</b><br>
     * Check the string is empty.
     *
     * @param val The string you want to check.
     * @return True while the string is empty, otherwise return false.
     */
    @Deprecated
    public static boolean IsEmpty(String val) {
        return val == null || val.length() == 0;
    }

    /**
     * <b>This method will be removed from version 3.5.0</b><br>
     * Check the string is not empty.
     *
     * @param val The string you want to check
     * @return True while the string is not empty, otherwise return false
     */
    @Deprecated
    public static boolean IsNotEmpty(String val) {
        return !isEmpty(val);
    }

    /**
     * Check the string is not empty. The same implementation with {@link #IsNotEmpty(String)} but with a java style
     * identifier.
     *
     * @param val The string you want to check
     * @return True while the string is not empty, otherwise return false
     */
    public static boolean isNotEmpty(String val) {
        return !isEmpty(val);
    }

    /**
     * Determine if the string contains only white space characters. The same implementation with
     * {@link #IsBlank(String)} but with a java style identifier.
     *
     * @param val The string you want to check
     * @return True while the string is blank, otherwise return false.
     * Blank means the string is meaningless, or it only got spaces or tabs in it.
     */
    public static boolean isBlank(String val) {
        return val.isBlank();
    }

    /**
     * <b>This method will be removed from version 3.5.0</b><br>
     * Determine if the string contains only white space characters.
     *
     * @param val The string you want to check
     * @return True while the string is blank, otherwise return false.
     * Blank means the string is meaningless, or it only got spaces or tabs in it.
     * @see String#isBlank()
     */
    @Deprecated
    public static boolean IsBlank(String val) {
        return val.isBlank();
    }

    /**
     * Format any string using wild card of "{@code {}}". The same implementation with
     * {@link #Format(String, Object...)} but with java style identifier.
     *
     * @param format The origin format string.
     * @param args   The args to be put into the string.
     * @return An formatted string.
     * @see #Format(String, Object...)
     */
    public static String format(String format, Object... args) {
        if (args.length == 0) {
            return format;
        }

        if (count(format, "{}") != args.length) {
            throw new RuntimeException("");
        }

        int i = 0;
        while (format.contains("{}")) {
            format = format.replaceFirst("\\{}", args[i].toString());
            i++;
        }

        return format;
    }

    /**
     * <b>This method will be removed from version 3.5.0</b><br>
     * Format any string using wild card of "{@code {}}".
     *
     * @param format The origin format string.
     * @param args   The args to be put into the string.
     * @return An formatted string.
     */
    @Deprecated
    public static String Format(String format, Object... args) {
        return format(format, args);
    }



}

