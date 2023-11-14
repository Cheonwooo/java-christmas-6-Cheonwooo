package christmas.validation;

import christmas.constant.NumberUtil;
import christmas.constant.message.ErrorMessage;

public class VisitDateValidation {

    public void validateVisitDateInput(String input) {
        validateInputInNull(input);
        validateVisitDateIsNotNumeric(input);
        validateValueExceedsIntRange(input);
        int date = Integer.parseInt(input);
        validateVisitDateOutOfRange(date);
    }

    public void validateInputInNull(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_ERROR_MESSAGE.getErrorMsg());
        }
    }

    public void validateVisitDateIsNotNumeric(String input) {
        String number = input.replaceAll("[0-9]", "");

        if (!number.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_ERROR_MESSAGE.getErrorMsg());
        }
    }

    public void validateValueExceedsIntRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_ERROR_MESSAGE.getErrorMsg());
        }
    }

    public void validateVisitDateOutOfRange(int date) {
        if (date < NumberUtil.MIN_DATE.getNumber() || date > NumberUtil.MAX_DATE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.VISIT_DATE_ERROR_MESSAGE.getErrorMsg());
        }
    }
}
