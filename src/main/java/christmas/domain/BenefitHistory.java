package christmas.domain;

import christmas.constant.*;
import christmas.constant.event.Present;
import christmas.constant.menu.MenuBoard;
import christmas.constant.message.OutputMessage;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class BenefitHistory {

    DiscountResult discountResult = new DiscountResult();

    public StringBuilder getBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {

        if (present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            return generateNoBenefitHistory();
        }

        return generateBenefitHistory(date, orderMenu, present);
    }

    public StringBuilder generateNoBenefitHistory() {
        StringBuilder history = new StringBuilder();

        history.append(OutputMessage.NOTHING.getOutputMsg()).append("\n");
        return history;
    }

    public StringBuilder generateBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {
        List<String> discountPrice = discountResult.summarizeDiscount(date, orderMenu, present);

        return IntStream.range(0, DiscountCategories.values().length)
                .filter(menuIndex -> !discountPrice.get(menuIndex).equals(String.valueOf(MenuBoard.NO_MENU.getPrice())))
                .mapToObj(menuIndex -> DiscountCategories.values()[menuIndex].getCategory() +
                        discountPrice.get(menuIndex) + "원" + "\n")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
    }
}