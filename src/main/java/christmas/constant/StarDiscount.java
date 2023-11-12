package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum StarDiscount {

    STAR("특별 할인", 1000, Arrays.asList(7, 25));

    private final String week;
    private final int discount;
    private final List<Integer> weekNumber;

    StarDiscount(String week, int discount, List<Integer> weekNumber) {
        this.week = week;
        this.discount = discount;
        this.weekNumber = weekNumber;
    }

    public String getWeek() {
        return week;
    }

    public int getDiscount() {
        return discount;
    }

    public List<Integer> getWeekNumber() {
        return weekNumber;
    }

    public static StarDiscount findDiscountForStar(int date) {
        return Arrays.stream(values())
                .filter(value -> value.hasDiscountForStar(date))
                .findAny()
                .orElse(null);
    }

    public boolean hasDiscountForStar(int starOfWeek) {
        return weekNumber.stream()
                .anyMatch(dayNumber -> dayNumber.equals(starOfWeek));
    }
}
