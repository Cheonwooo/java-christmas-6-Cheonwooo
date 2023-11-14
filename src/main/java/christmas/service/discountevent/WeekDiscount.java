package christmas.service.discountevent;

import christmas.service.util.DiscountCalculator;

import java.util.Map;

public class WeekDiscount {

    DiscountCalculator discountCalculator = new DiscountCalculator();

    public int getWeekDayDiscount(int dateNumber, Map<String, Integer> menu) {

        return discountCalculator.calculateWeekdayDiscount(dateNumber, menu);
    }

    public int getWeekendDiscount(int dateNumber, Map<String, Integer> menu) {

        return discountCalculator.calculateWeekendDiscount(dateNumber, menu);
    }
}
