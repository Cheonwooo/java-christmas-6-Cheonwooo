package christmas;

import christmas.constant.event.Present;
import christmas.constant.message.OutputMessage;
import christmas.domain.BenefitHistory;
import christmas.domain.ChristmasOrder;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;
import christmas.domain.PresentEvent;
import christmas.service.discountevent.PresentDiscount;
import christmas.service.discountevent.TotalDiscount;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasPromotion {
    BenefitHistory benefitHistory = new BenefitHistory();
    ChristmasOrder christmasOrder = new ChristmasOrder();
    TotalOrderPrice totalOrderPrice = new TotalOrderPrice();
    VisitDate visitDate = new VisitDate();
    PresentDiscount presentDiscount = new PresentDiscount();
    TotalDiscount totalDiscount = new TotalDiscount();
    PresentEvent presentEvent = new PresentEvent();
    OutputView outputView = new OutputView();

    public void getReservation() {
        int visitDate = getVisitDate();
        Map<String, Integer> orderMenu = getOrderMenu(visitDate);
        int totalPrice = getTotalPrice(orderMenu);

        generateDiscountEvent(visitDate, orderMenu, totalPrice);
    }

    public void generateDiscountEvent(int visitDate, Map<String, Integer> orderMenu, int totalPrice) {
        String present = getPresent(totalPrice);
        int totalDiscount = getBenefit(visitDate, orderMenu, present);
        getPayment(totalPrice, totalDiscount, present);
        getBadge(totalDiscount);
    }

    public int getVisitDate() {
        outputView.printGuidePhrases();
        return visitDate.getVisitDate();
    }

    public Map<String, Integer> getOrderMenu(int visitDate) {
        Map<String, Integer> orderMenu = christmasOrder.getOrderMenu();
        outputView.printPreviewEvent(visitDate);
        outputView.printMenu(orderMenu);

        return orderMenu;
    }

    public int getTotalPrice(Map<String, Integer> orderMenu) {
        int totalPrice = totalOrderPrice.orderPrice(orderMenu);
        outputView.printTotalOrderPrice(totalPrice);

        return totalPrice;
    }

    public String getPresent(int totalPrice) {
        String present = presentEvent.checkPresentEvent(totalPrice);
        outputView.printPresentEvent(present);

        return present;
    }

    public int getBenefit(int date, Map<String, Integer> orderMenu, String present) {
        int totalBenefitDiscount;
        StringBuilder history = new StringBuilder();
        if (present.equals(Present.NOT_EVENT_TARGET.getPresent())) {
            history.append(OutputMessage.NOTHING.getOutputMsg()).append("\n");
            outputView.printBenefitHistory(history);
            totalBenefitDiscount = getTotalBenefitDiscount(date, orderMenu, present);
            return totalBenefitDiscount;
        }
        history = benefitHistory.getBenefitHistory(date, orderMenu, present);
        outputView.printBenefitHistory(history);

        totalBenefitDiscount = getTotalBenefitDiscount(date, orderMenu, present);
        return totalBenefitDiscount;
    }

    public int getTotalBenefitDiscount(int date, Map<String, Integer> orderMenu, String present) {
        int totalBenefitDiscount = totalDiscount.calculateTotalBenefitDiscount(date, orderMenu, present);
        outputView.printTotalBenefitPrice(totalBenefitDiscount);

        return totalBenefitDiscount;
    }

    public void getPayment(int totalPrice, int totalDiscount, String present) {
        int presentMenuPrice = presentDiscount.getPresentMenuPrice(present);
        int payment = totalPrice - (totalDiscount - presentMenuPrice);
        outputView.printPayment(payment);
    }

    public void getBadge(int totalDiscount) {
        outputView.printBadge(totalDiscount);
    }
}