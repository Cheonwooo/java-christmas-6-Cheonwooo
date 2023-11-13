package christmas.service.DiscountEvent;

public class SpecialDiscount {

    public int getSpecialDiscount(int dateNumber) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        int specialDiscount = discountCalculator.calculateStarDiscount(dateNumber);

        return specialDiscount;
    }
}
