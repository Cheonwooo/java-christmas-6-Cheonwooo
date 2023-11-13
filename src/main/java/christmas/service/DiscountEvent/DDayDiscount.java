package christmas.service.DiscountEvent;

public class DDayDiscount {

    public int getDDayDiscount(int dateNumber) {
        int dDayDiscount = calculateDDayDiscount(dateNumber);

        return dDayDiscount;
    }

    public int calculateDDayDiscount(int date) {
        int dDayDiscount = 1000 + (date - 1) * 100;
        if (date > 25) {
            return 0;
        }
        return dDayDiscount;
    }
}
