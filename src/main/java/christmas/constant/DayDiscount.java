package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum DayDiscount {
    WEEKDAY("평일 할인", "디저트", Arrays.asList(1, 2, 3, 4, 7, 25)),
    WEEKEND("주말 할인", "메인", Arrays.asList(5, 6));

    private final String week;
    private final String discountMenuCode;
    private final List<Integer> weekNumber;

    DayDiscount(String week, String discountMenuCode, List<Integer> weekNumber) {
        this.week = week;
        this.discountMenuCode = discountMenuCode;
        this.weekNumber = weekNumber;
    }

    public String getWeek() {
        return week;
    }

    public String getDiscountMenuCode() {
        return discountMenuCode;
    }

    public List<Integer> getWeekNumber() {
        return weekNumber;
    }

    public static DayDiscount findDiscountForDate(int date) {
        return Arrays.stream(values())
                .filter(numberOfDayDiscount -> numberOfDayDiscount.hasDiscountForDate(date))
                .findAny()
                .orElse(null);
    }

    public boolean hasDiscountForDate(int date) {
        return weekNumber.stream()
                .anyMatch(dayNumber -> dayNumber.equals(date));
    }
}
