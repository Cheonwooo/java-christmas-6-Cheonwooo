package christmas.domain;

import christmas.constant.*;
import christmas.constant.event.Present;
import christmas.constant.menu.MenuBoard;
import christmas.service.DiscountResult;

import java.util.List;
import java.util.Map;

public class BenefitHistory {

    DiscountResult discountResult = new DiscountResult();

    public StringBuilder getBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {
        StringBuilder history = new StringBuilder();
        List<String> discountPrice = discountResult.summarizeDiscount(date, orderMenu, present);

        int orderMenuIndex = -1;
        for (DiscountCategories discountCategories : DiscountCategories.values()) {
            orderMenuIndex++;
            if (discountPrice.get(orderMenuIndex).equals(String.valueOf(MenuBoard.NO_MENU.getPrice()))) {
                continue;
            }
            history.append(discountCategories.getCategory()).append(discountPrice.get(orderMenuIndex)).append("원").append("\n");
        }
        return history;
    }

    public int getTotalDiscount(int date, Map<String, Integer> menu, String present) {
        int totalDiscount = 0;
        if (present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            return totalDiscount;
        }
        totalDiscount = discountResult.getTotalDiscount(date, menu, present);
        return totalDiscount;
    }


    public int getPresentMenuPrice(String present) {
        int presentMenuPrice = 0;
        if (!present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
            presentMenuPrice = presentMenuBoard.getPrice();
            return presentMenuPrice;
        }
        return presentMenuPrice;
    }
}