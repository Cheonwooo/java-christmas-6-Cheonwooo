package christmas.constant.util;

public enum SeparatorUtil {

    COMMA(","),
    DASH("-");

    private final String separator;

    SeparatorUtil(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
