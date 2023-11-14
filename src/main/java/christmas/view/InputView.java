package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.message.InputMessage;
import christmas.validation.OrderMenuValidation;
import christmas.validation.VisitDateValidation;

public class InputView {

    VisitDateValidation visitDateValidation = new VisitDateValidation();
    OrderMenuValidation orderMenuValidation = new OrderMenuValidation();

    public int getDate() {
        System.out.println(InputMessage.ENTER_VISIT_DATE.getInputMsg());

        try {
            String input = Console.readLine();
            visitDateValidation.validateVisitDateInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getDate();
        }
    }

    public String getMenu() {
        System.out.println(InputMessage.ENTER_ORDER_MENU.getInputMsg());

        try {
            String order = Console.readLine();
            orderMenuValidation.validateMenuOrderInput(order);
            return order;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getMenu();
        }
    }
}
