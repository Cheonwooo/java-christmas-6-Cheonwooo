package christmas.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VisitDateValidationTest {
    private VisitDateValidation visitDateValidation;

    @BeforeEach
    void setUp() {
        visitDateValidation = new VisitDateValidation();
    }

    @DisplayName("아무값도 입력하지 않는 경우")
    @Test
    void inputNothingValue() {
        String input = "";

        assertThatThrownBy(() -> visitDateValidation.validateInputInNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 다른 문자를 섞어 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "ab1", "1 2", "1ㅁ2"})
    void inputOtherCharacters(String input) {
        assertThatThrownBy(() -> visitDateValidation.validateVisitDateIsNotNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int형의 범위를 벗어나는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"11111111111", "-11111111111"})
    void exceedIntRange(String input) {
        assertThatThrownBy(() -> visitDateValidation.validateValueExceedsIntRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1이상 31이하의 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {-31, 0, 32})
    void inputValueIsOutOfRange(int input) {
        assertThatThrownBy(() -> visitDateValidation.validateVisitDateOutOfRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}