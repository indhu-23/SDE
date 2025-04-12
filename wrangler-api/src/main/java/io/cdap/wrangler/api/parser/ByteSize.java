package io.cdap.wrangler.api.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteSize extends Token {
  private static final Pattern PATTERN = Pattern.compile("(?i)([0-9.]+)\\s*(B|KB|MB|GB|TB)");
  private final long bytes;

  public ByteSize(String value) {
    super(value);
    this.bytes = parseBytes(value);
  }

  private long parseBytes(String value) {
    Matcher matcher = PATTERN.matcher(value.trim());
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid byte size format: " + value);
    }

    double number = Double.parseDouble(matcher.group(1));
    String unit = matcher.group(2).toUpperCase();

    switch (unit) {
      case "B": return (long) number;
      case "KB": return (long) (number * 1024);
      case "MB": return (long) (number * 1024 * 1024);
      case "GB": return (long) (number * 1024 * 1024 * 1024);
      case "TB": return (long) (number * 1024L * 1024 * 1024 * 1024);
      default: throw new IllegalArgumentException("Unknown unit: " + unit);
    }
  }

  public long getBytes() {
    return bytes;
  }

  @Override
  public String toString() {
    return bytes + " bytes";
  }
}
