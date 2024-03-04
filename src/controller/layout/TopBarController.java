package src.controller.layout;

import src.view.layout.TopBarView;

public class TopBarController {
    public TopBarView topBarView;

    public TopBarController() {
    }

    public void initView() {
        topBarView = new TopBarView();
    }

    public TopBarView getView() {
        return topBarView;
    }
}
