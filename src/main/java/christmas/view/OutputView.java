package christmas.view;

import christmas.constant.event.Present;
import christmas.constant.message.OutputMessage;
import christmas.domain.BadgeEvent;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printGuidePhrases() {
        System.out.println(OutputMessage.GUIDER_MESSAGE.getOutputMsg());
    }

    public void printPreviewEvent(int visitDate) {
        System.out.printf(OutputMessage.PREVIEW_MESSAGE.getOutputMsg(), visitDate);
    }

    public void printMenu(Map<String, Integer> orderMenu) {
        System.out.println(OutputMessage.ORDER_MENU_TITLE.getOutputMsg());

        for (Map.Entry<String, Integer> entry : orderMenu.entrySet()) {
            System.out.printf(OutputMessage.ORDER_MENU.getOutputMsg(), entry.getKey(), entry.getValue());
        }
    }

    public void printTotalOrderPrice(int price) {
        System.out.println(OutputMessage.TOTAL_ORDER_PRICE_TITLE.getOutputMsg());
        System.out.printf(OutputMessage.PRICE.getOutputMsg(), decimalFormat.format(price));
    }

    public void printPresentEvent(String present) {
        System.out.println(OutputMessage.PRESENT_MENU_TITLE.getOutputMsg());
        if (present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            System.out.println(OutputMessage.NOTHING.getOutputMsg());
            return;
        }

        if (!present.equals(Present.NO_PRESENT.getPresent())) {
            System.out.printf(OutputMessage.PRESENT_MENU.getOutputMsg(), present);
            return;
        }

        System.out.println(present);
    }

    public void printBenefitHistory(StringBuilder history) {
        System.out.println(OutputMessage.BENEFIT_HISTORY_TITLE.getOutputMsg());
        System.out.println(history);
    }

    public void printTotalBenefitPrice(int benefitPrice) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_HISTORY_TITLE.getOutputMsg());
        if (benefitPrice != 0) {
            System.out.print(OutputMessage.MINUS.getOutputMsg());
        }
        System.out.printf(OutputMessage.PRICE.getOutputMsg(), decimalFormat.format(benefitPrice));
    }

    public void printPayment(int payment) {
        System.out.println(OutputMessage.PAYMENT_TITLE.getOutputMsg());
        System.out.printf(OutputMessage.PRICE.getOutputMsg(), decimalFormat.format(payment));
    }

    public void printBadge(int totalDiscount) {
        System.out.println(OutputMessage.EVENT_BADGE_TITLE.getOutputMsg());
        System.out.println(BadgeEvent.getBadgeCategory(totalDiscount));
    }
}
