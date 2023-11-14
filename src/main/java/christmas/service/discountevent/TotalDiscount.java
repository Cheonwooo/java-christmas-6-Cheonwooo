package christmas.service.discountevent;

import christmas.constant.event.Present;

import java.util.Map;

public class TotalDiscount {

    DayFinder dayFinder = new DayFinder();
    DDayDiscount dDayDiscount = new DDayDiscount();
    PresentDiscount presentDiscount = new PresentDiscount();
    SpecialDiscount specialDiscount = new SpecialDiscount();
    WeekDiscount weekDiscount = new WeekDiscount();

    public int calculateTotalBenefitDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int totalBenefitDiscount = 0;
        if (present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            return totalBenefitDiscount;
        }
        totalBenefitDiscount = calculateTotalDiscount(date, orderMenu, present);
        return totalBenefitDiscount;
    }

    public int calculateTotalDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int dateNumber = dayFinder.calculateDate(date);
        int totalDiscount = 0;

        totalDiscount += dDayDiscount.getDDayDiscount(date);
        totalDiscount += weekDiscount.getWeekDayDiscount(dateNumber, orderMenu);
        totalDiscount += weekDiscount.getWeekendDiscount(dateNumber, orderMenu);
        totalDiscount += specialDiscount.getSpecialDiscount(dateNumber);
        totalDiscount += presentDiscount.getPresentDiscount(present);

        return totalDiscount;
    }
}
