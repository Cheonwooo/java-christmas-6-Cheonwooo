package christmas.domain;

import christmas.constant.menu.MenuBoard;

import java.util.Map;

public class TotalOrderPrice {

    public int orderPrice(Map<String, Integer> orderMenu) {
        int totalPrice = 0;

        for (Map.Entry<String, Integer> entry : orderMenu.entrySet()) {
            totalPrice += calculatePrice(entry.getKey(), entry.getValue());
        }

        return totalPrice;
    }

    public int calculatePrice(String menu, int menuCount) {
        MenuBoard menuInfo = MenuBoard.valueOfMenu(menu);

        return menuInfo.getPrice() * menuCount;
    }
}
