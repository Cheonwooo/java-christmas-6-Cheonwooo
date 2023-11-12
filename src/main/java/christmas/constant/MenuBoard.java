package christmas.constant;

import java.util.Arrays;

public enum MenuBoard {
    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000),
    T_BONE_STEAK("티본스테이크", 55000),
    BARBECUE_LIB("바비큐립",54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000),
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000),
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000),
    NOTHING("없음", 0);

    private final String menu;
    private final int price;

    MenuBoard(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public static MenuBoard valueOfMenu (String menu) {
        return Arrays.stream(values())
                .filter(value -> value.menu.equals((menu)))
                .findAny()
                .orElse(null);
    }
}
