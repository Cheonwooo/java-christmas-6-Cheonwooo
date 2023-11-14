package christmas.constant;

public enum Present {
    CHAMPAGNE(MenuBoard.CHAMPAGNE.getMenu(), 120000),
    NO_PRESENT("없음", 10000),
    NOT_EVENT_TARGET("대상아님", 0);

    private final String present;
    private final int totalPrice;

    Present(String present, int totalPrice) {
        this.present = present;
        this.totalPrice = totalPrice;
    }

    public String getPresent() {
        return present;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
