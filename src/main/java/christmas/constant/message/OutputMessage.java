package christmas.constant.message;

public enum OutputMessage {

    GUIDER_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + System.lineSeparator()),
    ORDER_MENU_TITLE(System.lineSeparator() + "<주문 메뉴>"),
    ORDER_MENU("%s %d개" + System.lineSeparator()),
    TOTAL_ORDER_PRICE_TITLE(System.lineSeparator() + "<할인 전 총주문 금액>"),
    PRICE("%s원" + System.lineSeparator()),
    PRESENT_MENU_TITLE(System.lineSeparator() + "<증정 메뉴>"),
    PRESENT_MENU("%s 1개" + System.lineSeparator()),
    NOTHING("없음"),
    BENEFIT_HISTORY_TITLE(System.lineSeparator() + "<혜택 내역>"),
    TOTAL_BENEFIT_HISTORY_TITLE("<총혜택 금액>"),
    PAYMENT_TITLE(System.lineSeparator() + "<할인 후 예상 결제 금약>"),
    EVENT_BADGE_TITLE(System.lineSeparator() + "<12월 이벤트 배지>"),
    MINUS("-");

    private final String outputMsg;

    OutputMessage(String outputMsg) {
        this.outputMsg = outputMsg;
    }

    public String getOutputMsg() {
        return outputMsg;
    }
}
