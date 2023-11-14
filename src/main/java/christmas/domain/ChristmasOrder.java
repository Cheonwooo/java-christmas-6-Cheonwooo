package christmas.domain;

import christmas.constant.util.SeparatorUtil;
import christmas.view.InputView;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasOrder {
    InputView inputView = new InputView();

    public Map<String, Integer> getOrderMenu() {
        String menu = inputView.getMenu();

        return countingMenu(menu.split(SeparatorUtil.COMMA.getSeparator()));
    }

    public Map<String, Integer> countingMenu(String[] input) {
        return Arrays.stream(input)
                .map(order -> order.split(SeparatorUtil.DASH.getSeparator()))
                .collect(Collectors.toMap(split -> split[0], split -> Integer.parseInt(split[1])));
    }
}
