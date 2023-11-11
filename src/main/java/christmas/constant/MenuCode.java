package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum MenuCode {
    APPETIZER("에피타이저", Arrays.asList(Menu.MUSHROOM_SOUP.getMenu(), Menu.TAPAS.getMenu(), Menu.CAESAR_SALAD.getMenu())),
    MAIN("메인", Arrays.asList(Menu.T_BONE_STAEK.getMenu(), Menu.BARBECUE_LIB.getMenu(), Menu.SEAFOOD_PASTA.getMenu(), Menu.CHRISTMAS_PASTA.getMenu())),
    DESSERT("디저트", Arrays.asList(Menu.CHOCOLATE_CAKE.getMenu(), Menu.ICE_CREAM.getMenu())),
    BEVERAGE("음료", Arrays.asList(Menu.ZERO_COLA.getMenu(), Menu.RED_WINE.getMenu(), Menu.CHAMPAGNE.getMenu()));

    private String menuCode;
    private List<String> menu;

    MenuCode(String menuCode, List<String> menu) {
        this.menuCode = menuCode;
        this.menu = menu;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public List<String> getMenu() {
        return menu;
    }
}
