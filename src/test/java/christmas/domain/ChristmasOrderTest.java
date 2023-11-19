package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChristmasOrderTest {

    private ChristmasOrder christmasOrder;

    @DisplayName("주문받은 메뉴의 이름과 개수가 정확하게 입력됐는지 확인")
    @Test
    void countingMenu() {
        christmasOrder = new ChristmasOrder();
        String[] orderMenu = {"티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"};
        Map<String, Integer> result = christmasOrder.countingMenu(orderMenu);

        Map<String, Integer> answer = new HashMap<>();
        answer.put("티본스테이크", 1);
        answer.put("바비큐립", 1);
        answer.put("초코케이크", 2);
        answer.put("제로콜라", 1);

        assertThat(result).isEqualTo(answer);
    }
}