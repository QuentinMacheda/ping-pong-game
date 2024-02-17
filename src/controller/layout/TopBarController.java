package src.controller.layout;

import src.view.layout.TopBarView;
import src.controller.MainController;

// SINGLETON DESIGN PATTERN USED

public class TopBarController {
    public static TopBarController selfInstance = new TopBarController();
    public TopBarView topBarView;

    private TopBarController() {
        topBarView = new TopBarView();

        // Handling onclick menu buttons
        // Exit Game
        topBarView.exit.setOnAction(e -> System.exit(0));

        // Change Players Name
        topBarView.player1.setOnAction(e -> {
            MainController.getInstance().displaySettings("player1");
        });
        topBarView.player2.setOnAction(e -> {
            MainController.getInstance().displaySettings("player2");
        });
    }

    public TopBarView getView() {
        return topBarView;
    }

    public static TopBarController getInstance() {
        return selfInstance; // Singleton
    }
}
