package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PresentEventTest {

    @DisplayName("할인 전 총주문 금액에 따른 증정 메뉴 확인")
    @ParameterizedTest
    @CsvSource({"120000, 샴페인", "13000, 없음"})
    void checkGiftBasedOnTotalPrice(int price, String present) {
        PresentEvent presentEvent = new PresentEvent();

        String answer = presentEvent.checkPresentEvent(price);

        assertThat(present).isEqualTo(answer);
    }
}