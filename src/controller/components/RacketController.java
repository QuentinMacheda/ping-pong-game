package src.controller.components;

import src.view.components.RacketView;

public class RacketController {
    public RacketView racketView;

    public RacketController(int width, int height) {
        racketView = new RacketView(width, height);
    }

    public void updateSize(double newWidth, double newHeight) {
        racketView.updateSize(newWidth, newHeight);
    }

    public RacketView getView() {
        return racketView;
    }
}
