package christmas.service.DiscountEvent;

import christmas.constant.MenuBoard;

public class PresentDiscount {

    public int getPresentDiscount(String present) {
        MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
        int presentMenuPrice = presentMenuBoard.getPrice();

        return presentMenuPrice;
    }
}
