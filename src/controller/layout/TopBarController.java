package src.controller.layout;

import src.view.MainView;
import src.view.layout.TopBarView;

public class TopBarController {
    public MainView mainView;
    public TopBarView topBarView;

    public TopBarController(MainView mainView) {
        topBarView = new TopBarView();

        // Handle onclick menu buttons
        topBarView.player1.setOnAction(e -> {
            topBarView.playersContainer.setVisible(false);
            mainView.settings();
        });
        topBarView.player2.setOnAction(e -> {
            topBarView.playersContainer.setVisible(false);

        });
        topBarView.exit.setOnAction(e -> System.exit(0));
    }
}
