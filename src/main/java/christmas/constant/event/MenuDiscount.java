package christmas.constant.event;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuDiscount {

    DESSERT_DISCOUNT("디저트", 2023),
    MAIN_DISCOUNT("메인", 2023);

    private final String menuCode;
    private final int discount;
    private static final Map<String, String> discountMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(MenuDiscount::getMenuCode, MenuDiscount::name)));

    MenuDiscount(String menuCode, int discount) {
        this.menuCode = menuCode;
        this.discount = discount;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public int getDiscount() {
        return discount;
    }

    public static MenuDiscount getMenuCategory(final String menuCode) {
        return MenuDiscount.valueOf(discountMap.get(menuCode));
    }
}
