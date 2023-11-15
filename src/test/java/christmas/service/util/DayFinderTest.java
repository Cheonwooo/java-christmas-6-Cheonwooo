package christmas.service.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DayFinderTest {

    @DisplayName("날짜를 월요일(1)~일요일(7),크리스마스(25)로 반환")
    @ParameterizedTest(name = "날짜:{0}일 -> {1}번째 요일")
    @CsvSource({"1, 5", "2, 6", "3, 7", "4, 1", "5, 2", "6, 3", "7, 4", "25, 25"})
    void checkDateNumber(int date, int dateNumber) {
        DayFinder dayFinder = new DayFinder();

        int result = dayFinder.calculateDate(date);

        assertThat(result).isEqualTo(dateNumber);
    }
}