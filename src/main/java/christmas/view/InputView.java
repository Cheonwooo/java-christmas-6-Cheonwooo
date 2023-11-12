package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.VisitDateValidation;

public class InputView {

    VisitDateValidation visitDateValidation = new VisitDateValidation();

    public int getDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        try {
            String input = Console.readLine();
            visitDateValidation.validateVisitDateInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return getDate();
        }
    }
}
