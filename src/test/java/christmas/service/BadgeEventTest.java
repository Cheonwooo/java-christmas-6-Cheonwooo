package christmas.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeEventTest {

    private BadgeEvent badgeEvent;

    @BeforeEach
    void setUp() {
        badgeEvent = new BadgeEvent();
    }

    @DisplayName("할인 금액별 이벤트 배지 확인")
    @ParameterizedTest(name = "할인가격: {0}원 배지: {1}")
    @CsvSource({"30000, 산타", "15000, 트리", "6000, 별", "1200, 없음"})
    void checkBadgeEventByDiscount(int discount, String badge) {
        String result = badgeEvent.getBadgeCategory(discount);
        String answer = badge;

        assertThat(result).isEqualTo(answer);
    }
}