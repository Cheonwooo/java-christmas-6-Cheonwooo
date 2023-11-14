package christmas.constant;

public enum Badge {

    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NO_BADGE("없음", 0);

    private final String badge;
    private final int price;

    Badge(String badge, int price) {
        this.badge = badge;
        this.price = price;
    }

    public String getBadge() {
        return badge;
    }

    public int getPrice() {
        return price;
    }


}
