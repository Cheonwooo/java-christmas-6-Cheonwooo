package christmas.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderMenuValidationTest {
    private OrderMenuValidation orderMenuValidation;

    @BeforeEach
    void setUp() {
        orderMenuValidation = new OrderMenuValidation();
    }

    @DisplayName("아무값도 입력하지 않은 경우")
    @Test
    void inputNothingValue() {
        String input = "";

        assertThatThrownBy(() -> orderMenuValidation.validateInputIsNull(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 쉼표(,)로 구분하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2.레드와인-1", "해산물파스타-2/레드와인-1", "해산물파스타-2 레드와인-1"})
    void menuWithoutCommaSeparator(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateCommaSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 이름과 개수 사이에 대시(-)를 사용하지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타:2,레드와인-1", "해산물파스타.2,레드와인-1", "해산물파스타-2,레드와인1"})
    void menuWithoutDashSeparator(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateDashSeparator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타:2,화이트와인-1", "바질페스토파스타.2,레드와인-1", "봉골레파스타-2,레드와인-1"})
    void menuNotOnMenuBoard(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateOrderNotOnMenuBoard(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수를 1보다 작은 수를 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-0,레드와인-1", "해산물파스타--1,레드와인-1", "해산물파스타-,레드와인-1"})
    void menuCountLessThanOne(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateMenuCountLessThanOne(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수의 총합이 20이 넘어가는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-3,시저샐러드-3,해산물파스타-2,티본스테이크-2,바비큐립-4,아이스크림-6,레드와인-6,초코케이크-3",
            "양송이수프-21", "초코케이크-30"})
    void TotalMenuCountExceedsLimit(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateTotalMenuCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴를 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,해산물파스타-1", "레드와인-1,레드와인-2"})
    void DuplicateOrder(String input) {
        assertThatThrownBy(() -> orderMenuValidation.validateDuplicatedOrder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}