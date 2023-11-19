package christmas.constant.util;

public enum DayUtil {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    CHRISTMAS(25),
    EVENT_YEAR(2023),
    EVENT_MONTH(12);

    private final int day;

    DayUtil(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
