package src.controller;

import src.view.SettingsView;

public class SettingsController {
    public SettingsView settingsView;

    public SettingsController(String type) {
        settingsView = new SettingsView();

        // Display the right setting view
        switch (type) {
            case "player1":
                settingsView.updatePlayerName();
                break;
            case "player2":
                settingsView.updatePlayerName();
                break;
            default:
                // Error because type of setting not recognized
                // To do : Handle error with a message
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
            default:
                // Error because type of setting not recognized
                // To do : Handle error with a message
                break;
        }

        MainController.getInstance().hideSettings();
    }
}
