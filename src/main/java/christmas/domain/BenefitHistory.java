package christmas.domain;

import christmas.constant.*;
import christmas.service.DayFinder;
import christmas.service.DiscountEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BenefitHistory {
    private int totalDiscount = 0;
    private List<String> discountPrice = new ArrayList<>();
    DayFinder dayFinder = new DayFinder();
    DiscountEvent discountEvent = new DiscountEvent();
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public StringBuilder getBenefitHistory(int date, Map<String, Integer> menu, String present) {
        StringBuilder history = new StringBuilder();
        summarizeDiscount(date, menu, present);

        int index = -1;
        for (DiscountCategories discountCategories : DiscountCategories.values()) {
            index++;
            if (discountPrice.get(index).equals("0")) {
                continue;
            }
            history.append(discountCategories.getCategory()).append(discountPrice.get(index)).append("원").append("\n");
        }
        return history;
    }

    public void summarizeDiscount(int date, Map<String, Integer> menu, String present) {
        int dateNumber = dayFinder.calculateDate(date);

        getDDayDiscount(date);
        getWeekDayDiscount(dateNumber, menu);
        getWeekendDiscount(dateNumber, menu);
        getSpecialDiscount(dateNumber);
        getPresentDiscount(present);
    }



        discountPrice.add(decimalFormat.format(presentMenuPrice));
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}