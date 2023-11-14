package christmas.constant;

public enum NumberUtil {

    CHRISTMAS_DDAY_BASE_DISCOUNT(1000),
    BASE_DATE(1),
    ADDITIONAL_DISCOUNT_PER_DAY(100),
    MAX_ORDER_COUNT(20),
    MIN_DATE(1),
    MAX_DATE(31);

    private final int number;

    NumberUtil(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
