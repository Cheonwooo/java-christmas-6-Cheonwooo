package christmas.domain;

import christmas.constant.event.Badge;

import java.util.Arrays;

public class BadgeEvent {

    public static String getBadgeCategory(int totalDiscount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> totalDiscount >= badge.getPrice())
                .findFirst()
                .orElse(Badge.NO_BADGE)
                .getBadge();
    }
}
