package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BenefitHistoryTest {

    private BenefitHistory benefitHistory;

    @BeforeEach
    void setUp() {
        benefitHistory = new BenefitHistory();
    }

    @DisplayName("총주문 금액이 10000원이 넘는 경우 혜택 내역 출력")
    @ParameterizedTest
    @MethodSource("provideHasPresent")
    void checkBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {
        String result = benefitHistory.generateBenefitHistory(date, orderMenu, present).toString();
        String answer = "크리스마스 디데이 할인: -1,200원\n"
                + "평일 할인: -4,046원\n"
                + "특별 할인: -1,000원\n"
                + "증정 이벤트: -25,000원\n";

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> provideHasPresent() {
        return Stream.of(
                Arguments.of(3, new HashMap<>() {{
                    put("티본스테이크", 1);
                    put("제로콜라", 1);
                    put("초코케이크", 2);
                    put("바비큐립", 1);
                }}, "샴페인")
        );
    }

    @DisplayName("총주문 금액이 10000원 이하인 경우 할인 혜택 없음 출력")
    @ParameterizedTest
    @MethodSource("provideNoPresent")
    void checkNoBenefitHistory(int date, Map<String, Integer> orderMenu, String present) {
        String result = benefitHistory.getBenefitHistory(date, orderMenu, present).toString();
        String answer = "없음\n";

        assertThat(result).isEqualTo(answer);
    }

    public static Stream<Arguments> provideNoPresent() {
        return Stream.of(
                Arguments.of(3, new HashMap<>() {{
                    put("타파스", 1);
                    put("제로콜라", 1);
                }}, "대상아님")
        );
    }
}