package christmas.service.DiscountEvent;

public class DDayDiscount {

    public int getDDayDiscount(int dateNumber) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        int dDayDiscount = discountCalculator.calculateDDayDiscount(dateNumber);

        return dDayDiscount;
    }
}