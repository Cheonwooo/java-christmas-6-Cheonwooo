package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TotalOrderPriceTest {

    private TotalOrderPrice totalOrderPrice;

    @BeforeEach
    void setUp() {
        totalOrderPrice = new TotalOrderPrice();
    }

    @DisplayName("메뉴 이름과 개수가 주어지면 금액을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideMenu")
    void calculateOrderMenuPrice(String orderMenu, int menuCount, int price) {
        int result = totalOrderPrice.calculatePrice(orderMenu, menuCount);

        assertThat(result).isEqualTo(price);
    }

    public static Stream<Arguments> provideMenu() {
        return Stream.of(
                Arguments.of("타파스", 1, 5500),
                Arguments.of("티본스테이크", 10, 550000),
                Arguments.of("초코케이크", 5, 75000)
        );
    }

    @DisplayName("주문한 메뉴에 대한 총 금액을 계산한다")
    @ParameterizedTest
    @MethodSource("provideOrderMenu")
    void calculateTotalOrderPrice(Map<String, Integer> orderMenu, int totalPrice) {
        int result = totalOrderPrice.getOrderTotalPrice(orderMenu);

        assertThat(result).isEqualTo(totalPrice);
    }

    public static Stream<Arguments> provideOrderMenu() {
        return Stream.of(
                Arguments.of(new HashMap<String, Integer>() {{
                    put("티본스테이크", 1);
                    put("바비큐립", 1);
                    put("초코케이크", 2);
                    put("제로콜라", 1);
                }}, 142000)
        );
    }
}