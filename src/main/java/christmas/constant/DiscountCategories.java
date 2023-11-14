package christmas.constant;

public enum DiscountCategories {
    CHRISTMAS_DdAY_DISCOUNT("크리스마스 디데이 할인: -"),
    WEEKDAY_DISCOUNT("평일 할인: -"),
    WEEKEND_DISCOUNT("주말 할인: -"),
    SPECIAL_DISCOUNT("특별 할인: -"),
    PRESENT_DISCOUNT("증정 이벤트: -");

    private final String category;

    DiscountCategories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
