package christmas.domain;

import christmas.constant.Separator;
import christmas.view.InputView;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasOrder {
    InputView inputView = new InputView();

    public int getVisitDate() {
        int date = inputView.getDate();

        return date;
    }

    public Map<String, Integer> getOrderMenu() {
        String menu = inputView.getMenu();
        Map<String, Integer> orderMenu = countingMenu(menu.split(Separator.COMMA.getSeparator()));

        return orderMenu;
    }

    public Map<String, Integer> countingMenu(String[] input) {
        return Arrays.stream(input)
                .map(order -> order.split(Separator.DASH.getSeparator()))
                .collect(Collectors.toMap(split -> split[0], split -> Integer.parseInt(split[1])));
    }
}
