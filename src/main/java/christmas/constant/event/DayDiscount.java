package christmas.constant.event;

import christmas.constant.util.DayUtil;

import java.util.Arrays;
import java.util.List;

public enum DayDiscount {
    WEEKDAY("평일 할인", "디저트", Arrays.asList(DayUtil.MONDAY.getDay(), DayUtil.THUESDAY.getDay(),
            DayUtil.WEDNESDAY.getDay(), DayUtil.THURSDAY.getDay(), DayUtil.SUNDAY.getDay(), DayUtil.CHRISTMAS.getDay())),
    WEEKEND("주말 할인", "메인", Arrays.asList(DayUtil.FRIDAY.getDay(), DayUtil.SATURDAY.getDay()));

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
