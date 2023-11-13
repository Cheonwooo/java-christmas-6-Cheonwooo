package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum MenuCode {
    APPETIZER("에피타이저", Arrays.asList(MenuBoard.MUSHROOM_SOUP.getMenu(), MenuBoard.TAPAS.getMenu(), MenuBoard.CAESAR_SALAD.getMenu())),
    MAIN("메인", Arrays.asList(MenuBoard.T_BONE_STEAK.getMenu(), MenuBoard.BARBECUE_LIB.getMenu(), MenuBoard.SEAFOOD_PASTA.getMenu(), MenuBoard.CHRISTMAS_PASTA.getMenu())),
    DESSERT("디저트", Arrays.asList(MenuBoard.CHOCOLATE_CAKE.getMenu(), MenuBoard.ICE_CREAM.getMenu())),
    BEVERAGE("음료", Arrays.asList(MenuBoard.ZERO_COLA.getMenu(), MenuBoard.RED_WINE.getMenu(), MenuBoard.CHAMPAGNE.getMenu()));

    private final String menuCode;
    private final List<String> menuNames;

    MenuCode(String menuCode, List<String> menuNames) {
        this.menuCode = menuCode;
        this.menuNames = menuNames;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public List<String> getMenu() {
        return menuNames;
    }

    public static MenuCode findByMenuCode(String menu) {
        return Arrays.stream(MenuCode.values())
                .filter(code -> code.hasMenuCode(menu))
                .findAny()
                .orElse(null);
    }

    public boolean hasMenuCode(String menu) {
        return menuNames.stream()
                .anyMatch(name -> name.equals(menu));
    }
}
