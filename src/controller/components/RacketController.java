package src.controller.components;

import src.model.components.RacketModel;
import src.view.components.RacketView;

public class RacketController {
    public RacketModel racketModel;
    public RacketView racketView;

    public RacketController(int width, int height) {
        racketModel = new RacketModel(width, height);
        racketView = new RacketView(racketModel.getWidth(), racketModel.getHeight());
    }

    public void updateSize(double newWidth, double newHeight) {
        racketModel.updateSize(newWidth, newHeight);
        racketView.updateSize(racketModel.getWidth(), racketModel.getHeight());
    }

    public RacketView getView() {
        return racketView;
    }
}
