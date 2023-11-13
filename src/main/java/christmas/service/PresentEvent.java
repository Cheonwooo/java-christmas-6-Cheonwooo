package christmas.service;

import christmas.constant.Present;

public class PresentEvent {

    public String checkPresentEvent(int totalPrice) {
        for(Present event : Present.values()) {
            if(totalPrice >= event.getTotalPrice()){
                return event.getPresent();
            }
        }
        return "없음";
    }
}
