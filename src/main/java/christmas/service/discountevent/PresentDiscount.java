package christmas.service.discountevent;

import christmas.constant.event.Present;
import christmas.constant.menu.MenuBoard;

public class PresentDiscount {

    public int getPresentDiscount(String present) {
        MenuBoard presentMenuBoard = MenuBoard.valueOfMenu(present);
        int presentMenuPrice = presentMenuBoard.getPrice();

        return presentMenuPrice;
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
