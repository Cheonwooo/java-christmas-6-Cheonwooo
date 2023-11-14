package christmas.service.DiscountEvent;

import christmas.constant.Day;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayFinder {

    public int calculateDate(int date) {
        if (date == Day.CHRISTMAS.getDay()) {
            return date;
        }
        LocalDate localDate = LocalDate.of(Day.EVENT_YEAR.getDay(), Day.EVENT_MONTH.getDay(), date);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int dayOfWeekNumber = dayOfWeek.getValue();

        return dayOfWeekNumber;
    }
}
