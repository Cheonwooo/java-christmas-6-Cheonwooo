package christmas.domain;

import christmas.constant.event.Present;

import java.util.Arrays;

public class PresentEvent {

    public String checkPresentEvent(int totalPrice) {
        return Arrays.stream(Present.values())
                .filter(event -> totalPrice >= event.getTotalPrice())
                .findFirst()
                .orElse(Present.NOT_EVENT_TARGET)
                .getPresent();
    }
}
