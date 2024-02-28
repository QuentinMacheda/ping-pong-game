package src.controller.layout;

import src.view.layout.TopBarView;

// SINGLETON DESIGN PATTERN USED

public class TopBarController {
    public static TopBarController selfInstance = new TopBarController();
    public TopBarView topBarView;

    private TopBarController() {
    }

    public void initView() {
        topBarView = new TopBarView();
    }

    public TopBarView getView() {
        return topBarView;
    }

    public static TopBarController getInstance() {
        return selfInstance;
    }
}
