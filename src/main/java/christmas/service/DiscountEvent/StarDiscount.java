package christmas.service.DiscountEvent;

public class StarDiscount {

    public int getSpecialDiscount(int dateNumber) {
        int specialDiscount = calculateStarDiscount(dateNumber);

        return specialDiscount;
    }

    public int calculateStarDiscount(int dateNumber) {
        christmas.constant.StarDiscount starDiscount = christmas.constant.StarDiscount.findDiscountForStar(dateNumber);

        if (starDiscount == null) {
            return 0;
        }

        int discountForStar = starDiscount.getDiscount();

        return discountForStar;
    }
}
