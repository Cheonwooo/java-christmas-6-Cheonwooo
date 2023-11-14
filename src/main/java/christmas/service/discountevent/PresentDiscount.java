package christmas.service.discountevent;

import christmas.constant.menu.MenuBoard;

public class PresentDiscount {

    public int getPresentDiscount(String present) {
        MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
        int presentMenuPrice = presentMenuBoard.getPrice();

        return presentMenuPrice;
    }
}
