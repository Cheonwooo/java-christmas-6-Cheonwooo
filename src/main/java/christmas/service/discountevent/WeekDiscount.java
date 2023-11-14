package christmas.service.discountevent;

import christmas.service.util.DiscountCalculator;

import java.util.Map;

public class WeekDiscount {

    DiscountCalculator discountCalculator = new DiscountCalculator();

    public int getWeekDayDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekdayDiscount = discountCalculator.calculateWeekdayDiscount(dateNumber, menu);

        return weekdayDiscount;
    }

    public int getWeekendDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekendDiscount = discountCalculator.calculateWeekendDiscount(dateNumber, menu);

        return weekendDiscount;
    }
}
