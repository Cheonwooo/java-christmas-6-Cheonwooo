package christmas.validation;

import christmas.constant.MenuBoard;
import christmas.constant.MenuCode;

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
        if (input.equals(null) || input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateCommaSeparator(String input) {
        String deleteCommaWithMenu = input.replaceAll("[0-9가-힣a-zA-zㄱ-ㅎ,-]", "");

        if (!deleteCommaWithMenu.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateDashSeparator(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .toList();

        for (String menuName : orderMenu) {
            String deleteSeparator = menuName.replaceAll("[0-9a-zA-Z가-힣]", "");

            if (!deleteSeparator.equals("-")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateOrderNotOnMenuBoard(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .map(name -> name.split("-")[0])
                .toList();

        for (String order : orderMenu) {
            MenuBoard menuBoard = MenuBoard.valueOfMenu(order);

            if (menuBoard == null) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateMenuCountLessThanOne(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .toList();

        for (String order : orderMenu) {
            String remainCount = order.replaceAll("[ㄱ-ㅎ가-힣a-zA-z]", "").replaceFirst("-", "");

            if (remainCount.isEmpty() || Integer.parseInt(remainCount) < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void validateTotalMenuCount(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .map(name -> name.split("-")[1])
                .toList();

        int totalCount = 0;
        for (String order : orderMenu) {
            totalCount += Integer.parseInt(order);
        }

        if (totalCount > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateDuplicatedOrder(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .map(name -> name.split("-")[0])
                .toList();

        List<String> deleteDuplicateOrder = orderMenu.stream()
                .distinct().toList();

        if (!orderMenu.equals(deleteDuplicateOrder)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void validateOrderOnlyBeverage(String input) {
        List<String> orderMenu = Arrays
                .stream(input.split(","))
                .map(name -> name.split("-")[0])
                .toList();

        Set<String> code = new HashSet<>();
        for(String order : orderMenu) {
            MenuCode menuCode = MenuCode.findByMenuCode(order);

            code.add(menuCode.getMenuCode());
        }

        if(code.size() == 1 && code.contains(MenuCode.BEVERAGE.getMenuCode())) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
