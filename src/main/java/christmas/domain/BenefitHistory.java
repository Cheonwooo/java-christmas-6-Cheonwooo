package christmas.domain;

import christmas.constant.*;
import christmas.service.DiscountResult;

import java.util.List;
import java.util.Map;

public class BenefitHistory {

    DiscountResult discountResult = new DiscountResult();

    public StringBuilder getBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {
        StringBuilder history = new StringBuilder();
        List<String> discountPrice = discountResult.summarizeDiscount(date, orderMenu, present);

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

    public int getTotalDiscount(int date, Map<String, Integer> menu, String present) {
        int totalDiscount = discountResult.getTotalDiscount(date, menu, present);
        return totalDiscount;
    }


    public int getPresentMenuPrice(String present) {
        int presentMenuPrice = 0;
        if(!present.equals("대상아님")) {
            MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
            presentMenuPrice = presentMenuBoard.getPrice();
            return presentMenuPrice;
        }
        return presentMenuPrice;
    }
}