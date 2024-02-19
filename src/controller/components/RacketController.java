package src.controller.components;

import src.model.components.RacketModel;
import src.view.components.RacketView;

public class RacketController {
    private RacketModel racketModel;
    private RacketView racketView;

    public RacketController() {
        racketModel = new RacketModel();
    }

    public void initView() {
        racketView = new RacketView();
    }

    public RacketView getView() {
        return racketView;
    }

    public double getWidth() {
        return racketModel.getWidth();
    }

    public double getHeight() {
        return racketModel.getHeight();
    }

    public void updateSize(double newWidth, double newHeight) {
        racketModel.updateSize(newWidth, newHeight);
        racketView.updateSize(this.getWidth(), this.getHeight());
    }
}
