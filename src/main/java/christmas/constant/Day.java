package christmas.constant;

public enum Day {
    MONDAY(1),
    THUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    CHRISTMAS(25);

    private final int day;

    Day(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
