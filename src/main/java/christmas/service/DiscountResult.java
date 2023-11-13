package christmas.service;

import christmas.service.DiscountEvent.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscountResult {
    private List<String> discountPrice = new ArrayList<>();
    DDayDiscount dDayDiscount = new DDayDiscount();
    PresentDiscount presentDiscount = new PresentDiscount();
    SpecialDiscount specialDiscount = new SpecialDiscount();
    WeekDiscount weekDiscount = new WeekDiscount();
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    DayFinder dayFinder = new DayFinder();

    public DiscountResult() {
    }

    public DiscountResult(List<String> discountPrice) {
        this.discountPrice = discountPrice;
    }

    public List<String> getDiscountPrice() {
        return discountPrice;
    }

    public DiscountResult summarizeDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int dateNumber = dayFinder.calculateDate(date);

        discountPrice.add(decimalFormat.format(String.valueOf(dDayDiscount.getDDayDiscount(dateNumber))));
        discountPrice.add(decimalFormat.format(String.valueOf(weekDiscount.getWeekDayDiscount(dateNumber, orderMenu))));
        discountPrice.add(decimalFormat.format(String.valueOf(weekDiscount.getWeekendDiscount(dateNumber, orderMenu))));
        discountPrice.add(decimalFormat.format(String.valueOf(specialDiscount.getSpecialDiscount(dateNumber))));
        discountPrice.add(decimalFormat.format(String.valueOf(presentDiscount.getPresentDiscount(present))));

        return new DiscountResult(discountPrice);
    }
}