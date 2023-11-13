package christmas.service.DiscountEvent;

import christmas.constant.DayDiscount;
import christmas.constant.MenuCode;
import christmas.constant.MenuDiscount;

import java.util.Map;

public class WeekDiscount {

    public int getWeekDayDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekdayDiscount = calculateWeekdayDiscount(dateNumber, menu);

        return weekdayDiscount;
    }

    public int getWeekendDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekendDiscount = calculateWeekendDiscount(dateNumber, menu);

        return weekendDiscount;
    }

    public int calculateWeekdayDiscount(int dateNumber, Map<String, Integer> menu) {
        DayDiscount dayDiscount = DayDiscount.findDiscountForDate(dateNumber);

        if (dayDiscount.getWeek().equals("주말 할인")) {
            return 0;
        }
        int weekdayDiscount = calculateDiscountForMenu(dayDiscount.getDiscountMenuCode(), menu);

        return weekdayDiscount;
    }

    public int calculateWeekendDiscount(int dateNumber, Map<String, Integer> menu) {
        DayDiscount dayDiscount = DayDiscount.findDiscountForDate(dateNumber);

        if (dayDiscount.getWeek().equals("평일 할인")) {
            return 0;
        }
        int weekendDiscount = calculateDiscountForMenu(dayDiscount.getDiscountMenuCode(), menu);

        return weekendDiscount;
    }

    public int calculateDiscountForMenu(String discountMenuCode, Map<String, Integer> menu) {
        int discountMenuCount = 0;
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuCode = MenuCode.findByMenuCode(entry.getKey()).getMenuCode();

            if (discountMenuCode.equals(menuCode)) {
                discountMenuCount += entry.getValue();
            }
        }
        int menuDiscount = MenuDiscount.getMenuCategory(discountMenuCode).getDiscount() * discountMenuCount;

        return menuDiscount;
    }
}
