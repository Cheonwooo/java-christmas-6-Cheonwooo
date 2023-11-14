package christmas.service.discountevent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TotalDiscountTest {

    @DisplayName("총할인 금액 확인")
    @ParameterizedTest
    @MethodSource("discountInfo")
    void checkTotalDiscount(int date, Map<String, Integer> orderMenu, String present) {
        TotalDiscount totalDiscount = new TotalDiscount();
        int result = totalDiscount.calculateTotalDiscount(date,orderMenu, present);
        int answer = 31246;

        assertThat(result).isEqualTo(answer);
    }

    private static Stream<Arguments> discountInfo() {
        return Stream.of(
                Arguments.of(3, new HashMap<String, Integer>() {{
                    put("티본스테이크", 1);
                    put("바비큐립", 1);
                    put("초코케이크", 2);
                    put("제로콜라", 1);
                }}, "샴페인")
        );
    }
}