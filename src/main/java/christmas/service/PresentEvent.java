package christmas.service;

import christmas.constant.Present;

public class PresentEvent {

    public String checkPresentEvent(int totalPrice) {
        for (Present event : Present.values()) {
            if (totalPrice >= event.getTotalPrice()) {
                return event.getPresent();
            }
        }
        return Present.NOT_EVENT_TARGET.getPresent();
    }
}
