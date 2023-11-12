package christmas.service;

import christmas.constant.MenuBoard;

public class PresentEvent {

    public String checkPresentEvent(int totalPrice) {
        if(totalPrice >= 120000) {
            return MenuBoard.CHAMPAGNE.getMenu();
        }
        return "없음";
    }
}
