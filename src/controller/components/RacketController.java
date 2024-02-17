package src.controller.components;

import src.view.components.RacketView;

public class RacketController {
    public RacketView racketView;

    public RacketController(int width, int height) {
        racketView = new RacketView(width, height);
    }

    public RacketView getView() {
        return racketView;
    }
}
