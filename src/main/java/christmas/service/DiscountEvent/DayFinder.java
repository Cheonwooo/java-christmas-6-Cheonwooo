package christmas.service.DiscountEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayFinder {

    public int calculateDate(int date) {
        if(date == 25) {
            return 25;
        }
        LocalDate localDate = LocalDate.of(2023, 12, date);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int dayOfWeekNumber = dayOfWeek.getValue();

        return dayOfWeekNumber;
    }
}
