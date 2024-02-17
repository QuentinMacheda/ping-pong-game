package src.controller;

import src.view.SettingsView;

public class SettingsController {
    public SettingsView settingsView;
    private double racketCurrentWidth;
    private double racketCurrentHeight;

    public SettingsController(String type) {
        settingsView = new SettingsView();
        racketCurrentWidth = GameController.getInstance().racketLeftController.getView().racket.getWidth();
        racketCurrentHeight = GameController.getInstance().racketLeftController.getView().racket.getHeight();

        // Display the right setting view
        switch (type) {
            case "player1":
                settingsView.playerNameView();
                break;
            case "player2":
                settingsView.playerNameView();
                break;
            case "racketSize":
                settingsView.racketSizeView(racketCurrentWidth, racketCurrentHeight);
                break;
            default:
                break;
        }

        // Call save() function onclick save button
        settingsView.saveBtn.setOnAction(e -> save(type));
    }

    private void save(String type) {
        switch (type) {
            case "player1":
                GameController.getInstance().playerLeftController.updateName(settingsView.newPlayerName.getText());
                break;
            case "player2":
                GameController.getInstance().playerRightController.updateName(settingsView.newPlayerName.getText());
                break;
            case "racketSize":
                GameController.getInstance().racketLeftController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                GameController.getInstance().racketRightController.updateSize(settingsView.widthSlider.getValue(),
                        settingsView.heightSlider.getValue());
                break;
            default:
                break;
        }

        MainController.getInstance().hideSettings();
    }
}
