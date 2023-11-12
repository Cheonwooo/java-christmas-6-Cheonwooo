package christmas.validation;

public class VisitDateValidation {

    public void validateVisitDateInput(String input) {
        validateInputInNull(input);
        validateVisitDateIsNotNumeric(input);
        validateValueExceedsIntRange(input);
        int date = Integer.parseInt(input);
        validateVisitDateOutOfRange(date);
    }

    public void validateInputInNull(String input) {
        if (input.equals(null) || input.equals("")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void validateVisitDateIsNotNumeric(String input) {
        String number = input.replaceAll("[0-9]", "");

        if (!number.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void validateValueExceedsIntRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public void validateVisitDateOutOfRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
