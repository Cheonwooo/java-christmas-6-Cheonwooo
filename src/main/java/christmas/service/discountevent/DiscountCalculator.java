package christmas.service.discountevent;

import christmas.constant.util.DayUtil;
import christmas.constant.event.DayDiscount;
import christmas.constant.menu.MenuCode;
import christmas.constant.event.MenuDiscount;
import christmas.constant.util.NumberUtil;
import christmas.constant.event.StarDiscount;

import java.util.Map;

public class DiscountCalculator {

    public int calculateDDayDiscount(int date) {
        int dDayDiscount = NumberUtil.CHRISTMAS_DDAY_BASE_DISCOUNT.getNumber()
                + (date - NumberUtil.BASE_DATE.getNumber()) * NumberUtil.ADDITIONAL_DISCOUNT_PER_DAY.getNumber();
        if (date > DayUtil.CHRISTMAS.getDay()) {
            return 0;
        }
        return dDayDiscount;
    }

    public int calculateWeekdayDiscount(int dateNumber, Map<String, Integer> menu) {
        DayDiscount dayDiscount = DayDiscount.findDiscountForDate(dateNumber);

        if (dayDiscount.getWeek().equals(DayDiscount.WEEKEND.getWeek())) {
            return 0;
        }

        return calculateDiscountForMenu(dayDiscount.getDiscountMenuCode(), menu);
    }

    public int calculateWeekendDiscount(int dateNumber, Map<String, Integer> menu) {
        DayDiscount dayDiscount = DayDiscount.findDiscountForDate(dateNumber);

        if (dayDiscount.getWeek().equals(DayDiscount.WEEKDAY.getWeek())) {
            return 0;
        }

        return calculateDiscountForMenu(dayDiscount.getDiscountMenuCode(), menu);
    }

    public int calculateDiscountForMenu(String discountMenuCode, Map<String, Integer> menu) {
        int discountMenuCount = 0;
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String menuCode = MenuCode.findByMenuCode(entry.getKey()).getMenuCode();

            if (discountMenuCode.equals(menuCode)) {
                discountMenuCount += entry.getValue();
            }
        }

        return MenuDiscount.getMenuCategory(discountMenuCode).getDiscount() * discountMenuCount;
    }

    public int calculateStarDiscount(int dateNumber) {
        StarDiscount starDiscount = StarDiscount.findDiscountForStar(dateNumber);

        if (starDiscount == null) {
            return 0;
        }

        return starDiscount.getDiscount();
    }
}
