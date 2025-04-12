package io.cdap.wrangler.api.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDuration extends Token {
  private static final Pattern PATTERN = Pattern.compile("(?i)([0-9.]+)\\s*(ms|s|min|h)");
  private final long milliseconds;

  public TimeDuration(String value) {
    super(value);
    this.milliseconds = parseMilliseconds(value);
  }

  private long parseMilliseconds(String value) {
    Matcher matcher = PATTERN.matcher(value.trim());
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid time duration format: " + value);
    }

    double number = Double.parseDouble(matcher.group(1));
    String unit = matcher.group(2).toLowerCase();

    switch (unit) {
      case "ms": return (long) number;
      case "s": return (long) (number * 1000);
      case "min": return (long) (number * 60 * 1000);
      case "h": return (long) (number * 60 * 60 * 1000);
      default: throw new IllegalArgumentException("Unknown unit: " + unit);
    }
  }

  public long getMilliseconds() {
    return milliseconds;
  }

  @Override
  public String toString() {
    return milliseconds + " ms";
  }
}
