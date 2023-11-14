package christmas.service.DiscountEvent;

import christmas.constant.util.DayUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayFinder {

    public int calculateDate(int date) {
        if (date == DayUtil.CHRISTMAS.getDay()) {
            return date;
        }
        LocalDate localDate = LocalDate.of(DayUtil.EVENT_YEAR.getDay(), DayUtil.EVENT_MONTH.getDay(), date);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return dayOfWeek.getValue();
    }
}
