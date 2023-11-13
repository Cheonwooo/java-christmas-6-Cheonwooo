package christmas.service;

import christmas.constant.MenuCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountEventTest {

    private DiscountEvent discountEvent;

    @BeforeEach
    void setUp() {
        discountEvent = new DiscountEvent();
    }

    @DisplayName("크리스마스 디데이 할인 확인")
    @ParameterizedTest(name = "{0}일 할인 금액: {1}원")
    @CsvSource({"1, 1000", "5, 1400", "10, 1900", "25, 3400", "26, 0", "31, 0"})
    void checkChristmasDDayDiscount(int date, int discount) {
        int result = discountEvent.getDDayDiscount(date);
        int answer = discount;

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("할인이 적용되는 메뉴 카테고리에 해당하는 메뉴 할인 확인")
    @ParameterizedTest(name = "할인 금액: {2}원")
    @MethodSource("MenuCodeAndOrderMenu")
    void checkDiscountForMenuCategory(String menuCode, Map<String, Integer> orderMenu, int discount) {
        int result = discountEvent.getDiscount(menuCode, orderMenu);
        int answer = discount;
        assertThat(result).isEqualTo(answer);

    }

    private static Stream<Arguments> MenuCodeAndOrderMenu() {
        return Stream.of(
                Arguments.of(MenuCode.DESSERT.getMenuCode(), new HashMap<String, Integer>() {{
                    put("초코케이크", 1);
                    put("아이스크림", 2);
                    put("티본스테이크", 1);
                }}, 6069),
                Arguments.of(MenuCode.DESSERT.getMenuCode(), new HashMap<String, Integer>() {{
                    put("초코케이크", 2);
                    put("바비큐립", 3);
                    put("해산물파스타", 6);
                }}, 4046),
                Arguments.of(MenuCode.MAIN.getMenuCode(), new HashMap<String, Integer>() {{
                    put("초코케이크", 1);
                    put("아이스크림", 2);
                    put("티본스테이크", 1);
                }}, 2023),
                Arguments.of(MenuCode.MAIN.getMenuCode(), new HashMap<String, Integer>() {{
                    put("초코케이크", 2);
                    put("바비큐립", 3);
                    put("해산물파스타", 6);
                }}, 18207)
        );
    }

    @DisplayName("평일 할인 확인")
    @ParameterizedTest
    @MethodSource("dateNumberAndOrderMenu")
    void checkWeekdayDiscount(int dateNumber, Map<String, Integer> orderMenu, List<Integer> discount) {
        int result = discountEvent.getWeekdayDiscount(dateNumber, orderMenu);
        int answer = discount.get(0);

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("주말 할인 확인")
    @ParameterizedTest
    @MethodSource("dateNumberAndOrderMenu")
    void checkWeekendDiscount(int dateNumber, Map<String, Integer> orderMenu, List<Integer> discount) {
        int result = discountEvent.getWeekendDiscount(dateNumber, orderMenu);
        int answer = discount.get(1);

        assertThat(result).isEqualTo(answer);
    }

    private static Stream<Arguments> dateNumberAndOrderMenu() {
        return Stream.of(
                Arguments.of(1, new HashMap<String, Integer>() {{
                    put("초코케이크", 1);
                    put("아이스크림", 2);
                    put("티본스테이크", 1);
                }}, Arrays.asList(6069, 0)),
                Arguments.of(6, new HashMap<String, Integer>() {{
                    put("초코케이크", 1);
                    put("아이스크림", 2);
                    put("티본스테이크", 1);
                }}, Arrays.asList(0, 2023))
        );
    }

    @DisplayName("특별 할인(별이 있는 날짜) 확인")
    @ParameterizedTest(name = "특별 할인: {1}원")
    @CsvSource({"1, 0", "7, 1000", "25, 1000"})
    void checkStarDiscount(int dateNumber, int discount) {
        int result = discountEvent.getStarDiscount(dateNumber);
        int answer = discount;

        assertThat(result).isEqualTo(answer);
    }
}