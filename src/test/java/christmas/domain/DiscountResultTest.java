package christmas.domain;

import christmas.domain.DiscountResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountResultTest {

    private DiscountResult discountResult;

    @BeforeEach
    void setUp() {
        discountResult = new DiscountResult();
    }

    @DisplayName("할인 금액들을 저장한 값 확인")
    @ParameterizedTest
    @MethodSource("discountInfo")
    void checkDiscountResult(int date, Map<String, Integer> orderMenu, String present) {
        List<String> result = discountResult.summarizeDiscount(date, orderMenu, present);
        List<String> answer = Arrays.asList("1,200", "4,046", "0", "1,000", "25,000");

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