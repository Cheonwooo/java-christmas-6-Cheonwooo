package christmas.validation;

import christmas.constant.menu.MenuBoard;
import christmas.constant.menu.MenuCode;
import christmas.constant.util.NumberUtil;
import christmas.constant.util.SeparatorUtil;
import christmas.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenuValidation {
    public void validateMenuOrderInput(String input) {
        validateInputIsNull(input);
        validateCommaSeparator(input);
        validateDashSeparator(input);
        validateOrderNotOnMenuBoard(input);
        validateMenuCountLessThanOne(input);
        validateTotalMenuCount(input);
        validateDuplicatedOrder(input);
        validateOrderOnlyBeverage(input);
    }

    public void validateInputIsNull(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg());
        }
    }

    public void validateCommaSeparator(String input) {
        String deleteCommaWithMenu = input.replaceAll("[0-9가-힣a-zA-zㄱ-ㅎ,-]", "");

        if (!deleteCommaWithMenu.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 1);
        }
    }

    public void validateDashSeparator(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .toList();

        for (String menuName : orderMenu) {
            String deleteSeparator = menuName.replaceAll("[0-9ㄱ-ㅎ가-힣a-zA-z]", "");

            if (!deleteSeparator.equals(SeparatorUtil.DASH.getSeparator())) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 2);
            }
        }
    }

    public void validateOrderNotOnMenuBoard(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .map(name -> name.split(SeparatorUtil.DASH.getSeparator())[0])
                .toList();

        for (String order : orderMenu) {
            MenuBoard menuBoard = MenuBoard.valueOfMenu(order);

            if (menuBoard == null) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 3);
            }
        }
    }

    public void validateMenuCountLessThanOne(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .toList();

        for (String order : orderMenu) {
            String remainCount = order
                    .replaceAll("[ㄱ-ㅎ가-힣a-zA-z]", "")
                    .replaceFirst(SeparatorUtil.DASH.getSeparator(), "");

            if (remainCount.isEmpty() || Integer.parseInt(remainCount) < 1) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 4);
            }
        }
    }

    public void validateTotalMenuCount(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .map(name -> name.split(SeparatorUtil.DASH.getSeparator())[1])
                .toList();

        int totalCount = 0;
        for (String order : orderMenu) {
            totalCount += Integer.parseInt(order);
        }

        if (totalCount > NumberUtil.MAX_ORDER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 5);
        }
    }

    public void validateDuplicatedOrder(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .map(name -> name.split(SeparatorUtil.DASH.getSeparator())[0])
                .toList();

        List<String> deleteDuplicateOrder = orderMenu.stream()
                .distinct().toList();

        if (!orderMenu.equals(deleteDuplicateOrder)) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 6);
        }
    }

    public void validateOrderOnlyBeverage(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(SeparatorUtil.COMMA.getSeparator()))
                .map(name -> name.split(SeparatorUtil.DASH.getSeparator())[0])
                .toList();

        Set<String> code = new HashSet<>();
        for (String order : orderMenu) {
            MenuCode menuCode = MenuCode.findByMenuCode(order);

            code.add(menuCode.getMenuCode());
        }

        if (code.size() == 1 && code.contains(MenuCode.BEVERAGE.getMenuCode())) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR_MESSAGE.getErrorMsg() + 7);
        }
    }
}
