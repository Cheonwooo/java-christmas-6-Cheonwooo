package christmas.service;

import christmas.constant.event.Badge;

public class BadgeEvent {

    public static String getBadgeCategory(int totalDiscount) {
        for (Badge badgeCategory : Badge.values()) {
            if (totalDiscount >= badgeCategory.getPrice()) {
                return badgeCategory.getBadge();
            }
        }
        return Badge.NO_BADGE.getBadge();
    }
}
