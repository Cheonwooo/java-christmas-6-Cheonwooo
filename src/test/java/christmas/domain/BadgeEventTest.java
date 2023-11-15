package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeEventTest {

    @DisplayName("할인 금액별 이벤트 배지 확인")
    @ParameterizedTest(name = "할인가격: {0}원 배지: {1}")
    @CsvSource({"30000, 산타", "15000, 트리", "6000, 별", "1200, 없음"})
    void checkBadgeEventByDiscount(int discount, String badge) {
        BadgeEvent badgeEvent = new BadgeEvent();

        String result = badgeEvent.getBadgeCategory(discount);

        assertThat(result).isEqualTo(badge);
    }
}