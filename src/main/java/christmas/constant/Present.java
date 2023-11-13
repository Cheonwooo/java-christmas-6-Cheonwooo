package christmas.constant;

public enum Present {
    CHAMPAGNE(MenuBoard.CHAMPAGNE.getMenu(), 120000),
    NOTHING("없음", 10000);

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
