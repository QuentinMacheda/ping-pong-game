package src.view;

import javafx.scene.layout.BorderPane;
import src.controller.layout.TopBarController;

public class SettingsView extends BorderPane {
    public TopBarController topBarController;

    public SettingsView(MainView mainView) {
        // Set Top Bar
        topBarController = new TopBarController(mainView);
        this.setTop(topBarController.topBarView);

        this.setStyle("-fx-background-color: #FFFFFF");
    }
}
