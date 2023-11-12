package christmas.domain;

import christmas.view.InputView;

public class ChristmasOrder {
    InputView inputView = new InputView();

    public int getVisitDate() {
        int date = inputView.getDate();

        return date;
    }

}
