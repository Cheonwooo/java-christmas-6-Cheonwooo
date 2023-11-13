package christmas.view;

import christmas.service.BadgeEvent;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printGuidePhrases() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printPreviewEvent(int visitDate) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", visitDate);
    }

    public void printMenu(Map<String, Integer> orderMenu) {
        System.out.println();
        System.out.println("<주문 메뉴>");

        for (Map.Entry<String, Integer> entry : orderMenu.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
    }

    public void printTotalOrderPrice(int price) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(price) + "원");
    }

    public void printPresentEvent(String present) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (!present.equals("없음")) {
            System.out.println(present + " 1개");
            return;
        }
        System.out.println(present);
    }

    public void printBenefitHistory(StringBuilder history) {
        System.out.println();
        System.out.println("<혜택 내역>");
        System.out.println(history);
    }

    public void printTotalBenefitPrice(int benefitPrice) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + decimalFormat.format(benefitPrice) + "원");
    }

    public void printPayment(int payment) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(payment) + "원");
    }

    public void printBadge(int totalDiscount) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(BadgeEvent.getBadgeCategory(totalDiscount));
    }
}
