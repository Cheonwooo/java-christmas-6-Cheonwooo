package christmas.service;

import christmas.service.DiscountEvent.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountResult {
    DDayDiscount dDayDiscount = new DDayDiscount();
    PresentDiscount presentDiscount = new PresentDiscount();
    SpecialDiscount specialDiscount = new SpecialDiscount();
    WeekDiscount weekDiscount = new WeekDiscount();
    TotalDiscount totalDiscount = new TotalDiscount();
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    DayFinder dayFinder = new DayFinder();

    public List<String> summarizeDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int dateNumber = dayFinder.calculateDate(date);
        List<String> discountPrice = new ArrayList<>();

        discountPrice.add(decimalFormat.format(dDayDiscount.getDDayDiscount(date)));
        discountPrice.add(decimalFormat.format(weekDiscount.getWeekDayDiscount(dateNumber, orderMenu)));
        discountPrice.add(decimalFormat.format(weekDiscount.getWeekendDiscount(dateNumber, orderMenu)));
        discountPrice.add(decimalFormat.format(specialDiscount.getSpecialDiscount(dateNumber)));
        discountPrice.add(decimalFormat.format(presentDiscount.getPresentDiscount(present)));

        return discountPrice;
    }

    public int getTotalDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int discount = totalDiscount.calculateTotalDiscount(date, orderMenu, present);

        return discount;
    }
}