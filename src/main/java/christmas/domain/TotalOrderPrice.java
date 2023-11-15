package christmas.domain;

import christmas.constant.menu.MenuBoard;

import java.util.Map;

public class TotalOrderPrice {

    public int getOrderTotalPrice(Map<String, Integer> orderMenu) {
        int totalPrice = orderMenu.entrySet()
                .stream()
                .mapToInt(entry -> calculatePrice(entry.getKey(), entry.getValue()))
                .sum();

        return totalPrice;
    }

    public int calculatePrice(String menu, int menuCount) {
        MenuBoard menuInfo = MenuBoard.valueOfMenu(menu);

        return menuInfo.getPrice() * menuCount;
    }
}
