package christmas.domain;

import christmas.constant.*;
import christmas.service.DiscountEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BenefitHistory {
    private List<String> discountPrice = new ArrayList<>();
    DiscountEvent discountEvent = new DiscountEvent();
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public StringBuilder getBenefitHistory(int date, Map<String, Integer> menu, String present) {
        StringBuilder history = new StringBuilder();

        int index = -1;
        for(DiscountCategories discountCategories : DiscountCategories.values()) {
            index++;
            if(discountPrice.get(index).equals("0")) {
                continue;
            }
            history.append(discountCategories.getCategory()).append(discountPrice.get(index)).append("원").append("\n");
        }
        return history;
    }

    public void getDDayDiscount(int dateNumber) {
        int dDayDiscount = discountEvent.getDDayDiscount(dateNumber);

        discountPrice.add(decimalFormat.format(dDayDiscount));
    }

    public void getWeekDayDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekdayDiscount = discountEvent.getWeekdayDiscount(dateNumber, menu);

        discountPrice.add(decimalFormat.format(weekdayDiscount));
    }

    public void getWeekendDiscount(int dateNumber, Map<String, Integer> menu) {
        int weekendDiscount = discountEvent.getWeekendDisCount(dateNumber, menu);

        discountPrice.add(decimalFormat.format(weekendDiscount));
    }

    public void getSpecialDiscount(int dateNumber) {
        int specialDiscount = discountEvent.getStarDiscount(dateNumber);

        discountPrice.add(decimalFormat.format(specialDiscount));
    }

    public void getPresentDiscount(String present) {
        MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
        int presentMenuPrice = presentMenuBoard.getPrice();

        discountPrice.add(decimalFormat.format(presentMenuPrice));
    }

}