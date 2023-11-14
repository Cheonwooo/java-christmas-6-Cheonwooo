package christmas.constant;

public enum Separator {

    COMMA(","),
    DASH("-");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
