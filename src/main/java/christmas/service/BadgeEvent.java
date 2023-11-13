package christmas.service;

import christmas.constant.Badge;

public class BadgeEvent {

    public static String getBadgeCategory(int totalDiscount) {
        for(Badge badgeCategory : Badge.values()) {
            if(totalDiscount >= badgeCategory.getPrice()) {
                return badgeCategory.getBadge();
            }
        }
        return "없음";
    }
}
